package lotto;

import java.util.List;

public class LottoBank {
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private int containsCount = 0;

    public void LottoNumberCompareResult(List<List<Integer>> totalLotteries, List<Integer> winningNumbers) {
        int[] rankCount = new int[8];
        for (List<Integer> lotto : totalLotteries) {
            countContainsNumber(lotto, winningNumbers);
            rankCount[containsCount]++;
            containsCount = 0;
        }
    }

    public void countContainsNumber(List<Integer> lotto, List<Integer> winningNumbers) {
        for (int number : lotto) {
            if (isContainNumber(number, winningNumbers)) {
                containsCount++;
            }
        }
    }

    public boolean isContainNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
