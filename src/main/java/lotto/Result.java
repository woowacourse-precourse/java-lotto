package lotto;
import java.util.List;

public class Result {

    int[] totalWin = {0, 0, 0, 0, 0};   // totalWin[i] = i+1등인 로또 개수
    int totalPrize;

    Result(List<List<Integer>> myLotto, List<Integer> winningLotto, int winningBonus) {
        for (int i = 0; i < myLotto.size(); i++) {
            Compare compare = new Compare(myLotto.get(i), winningLotto, winningBonus);
            judgeWin(compare.sameNumberCnt, compare.isBonusSame);
        }
        totalPrize = calculateTotalPrize();
        new PrintStatistics(myLotto.size(), totalWin, totalPrize);
    }

    private void judgeWin(int sameNumberCnt, boolean isBonusSame) {
        if (sameNumberCnt == 6) {
            totalWin[0]++;
            return;
        }
        if ((sameNumberCnt == 5) && (isBonusSame)) {
            totalWin[1]++;
            return;
        }
        if ((sameNumberCnt == 5) && (!isBonusSame)) {
            totalWin[2]++;
            return;
        }
        if (sameNumberCnt == 4) {
            totalWin[3]++;
            return;
        }
        if (sameNumberCnt == 3) {
            totalWin[4]++;
            return;
        }
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (int i = 0; i < totalWin.length; i++) {
            totalPrize += Win.values()[i].prize() * totalWin[i];
            System.out.println(totalPrize);
        }
        return totalPrize;
    }
}
