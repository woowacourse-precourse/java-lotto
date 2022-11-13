package lotto;

import java.util.List;

public class LottoBank {
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private int containsCount = 0;

    public void LottoNumberCompareResult() {
        List<List<Integer>> totalLotteries = lottoMachine.sortLottoNumbers();
        int[] rankCount = new int[8];
        for (List<Integer> lotto : totalLotteries) {
            for (int number : lotto) {
                countContainsNumber(number);
            }
            for (int i=0; i<containsCount; i++) {
                rankCount[containsCount]++;
            }
            containsCount = 0;
        }
    }

    public void countContainsNumber(int number) {
        if (isContainNumber(number)) {
            containsCount++;
        }
    }

    public boolean isContainNumber(int number) {
        List<Integer> winningNumbers = winningLotto.creteWinningNumbers();
        if (winningNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
