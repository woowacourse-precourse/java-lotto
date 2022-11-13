package lotto;

import java.util.List;

public class LottoBank {
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private int containsCount = 0;

    public void LottoNumberCompareResult(List<List<Integer>> totalLotteries, List<Integer> winningNumbers) {
        int[] rankCount = new int[8];
        for (List<Integer> lotto : totalLotteries) {
            for (int number : lotto) {
                countContainsNumber(number, winningNumbers);
            }
            for (int i = 0; i < containsCount; i++) {
                rankCount[containsCount]++;
            }
            containsCount = 0;
        }
        for (int i = 0; i < rankCount.length; i++) {
            System.out.println(rankCount[i]);
        }
    }

    public void countContainsNumber(int number, List<Integer> winningNumbers) {
        if (isContainNumber(number, winningNumbers)) {
            containsCount++;
        }
    }

    public boolean isContainNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
