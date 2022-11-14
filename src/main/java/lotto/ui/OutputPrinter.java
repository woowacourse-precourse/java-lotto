package lotto.ui;

import lotto.domain.WinningNumbers;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputPrinter {
    public OutputPrinter() {}

    public void printPurchasedNumbers(long bundleSize, List<List<Integer>> lottoBundle) {
        System.out.println(bundleSize + "개를 구매했습니다.");

        for (List<Integer> singleLotto : lottoBundle) {
            Collections.sort(singleLotto);
            System.out.println(singleLotto);
        }
    }
    public void printFinalResult(Map<WinningNumbers, Long> winningCase, double rawRatio) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printWinningStatistics(winningCase);
        printRewardRate(rawRatio);
    }

    private void printWinningStatistics(Map<WinningNumbers, Long> winningCase) {
        WinningNumbers[] allWinningNumbers = WinningNumbers.values();
        for (int winningNumberIndex = 0; winningNumberIndex < allWinningNumbers.length - 1; winningNumberIndex++) {
            WinningNumbers key = allWinningNumbers[winningNumberIndex];
            int matches = key.getMatch();
            long reward = key.getReward();
            long winningCounter = winningCase.getOrDefault(key, 0L);
            DecimalFormat commaInMoney = new DecimalFormat("###,###");

            System.out.println(matches + "개 일치 (" + commaInMoney.format(reward) + "원) - " + winningCounter + "개");
        }
    }

    private void printRewardRate(double rawRatio) {
        System.out.println("총 수익률은 "+ String.format("%.1f", rawRatio) + "%입니다.");
    }
}
