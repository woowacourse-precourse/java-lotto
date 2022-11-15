package lotto.domain.result;

import lotto.domain.result.domain.Compare;
import lotto.domain.result.domain.PrintStatistics;
import lotto.domain.result.domain.Win;

import java.util.List;

public class Result {

    public int[] totalWin = {0, 0, 0, 0, 0};   // totalWin[i] = i+1등인 로또 개수
    public int totalPrize;

    public Result(List<List<Integer>> myLotto, List<Integer> winningLotto, int winningBonus) {
        for (int i = 0; i < myLotto.size(); i++) {
            Compare compare = new Compare(myLotto.get(i), winningLotto, winningBonus);
            judgeWin(compare.sameNumberCnt, compare.isBonusSame);
        }
        totalPrize = calculateTotalPrize();
        new PrintStatistics(myLotto.size(), totalWin, totalPrize);
    }

    private void judgeWin(int sameNumberCnt, boolean isBonusSame) {
        if (sameNumberCnt == Win.FIRST.sameNumberCnt()) {
            totalWin[0]++;
            return;
        }
        if ((sameNumberCnt == Win.SECOND.sameNumberCnt()) && (isBonusSame)) {
            totalWin[1]++;
            return;
        }
        if ((sameNumberCnt == Win.THIRD.sameNumberCnt()) && (!isBonusSame)) {
            totalWin[2]++;
            return;
        }
        if (sameNumberCnt == Win.FOURTH.sameNumberCnt()) {
            totalWin[3]++;
            return;
        }
        if (sameNumberCnt == Win.FIFTH.sameNumberCnt()) {
            totalWin[4]++;
            return;
        }
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (int i = 0; i < totalWin.length; i++) {
            totalPrize += Win.values()[i].prize() * totalWin[i];
        }
        return totalPrize;
    }
}
