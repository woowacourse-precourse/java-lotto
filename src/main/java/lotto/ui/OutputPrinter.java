package lotto.ui;

import lotto.domain.WinningNumbers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputPrinter {
    public OutputPrinter() {}

    public void printPurchasedNumbers(List<List<Integer>> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매했습니다.");

        for (List<Integer> singleLotto : lottoBundle) {
            List<Integer> tmp = new ArrayList<>();
            for (int element : singleLotto) {
                tmp.add(element);
            }
            Collections.sort(tmp);

            System.out.println(tmp);
        }
        System.out.println();
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
            System.out.println(outputResultFormat(key, winningCase, allWinningNumbers[winningNumberIndex]));
        }
    }

    private String outputResultFormat(WinningNumbers key, Map<WinningNumbers, Long> winningCase, WinningNumbers rank) {
        int matches = key.getMatch();
        long reward = key.getReward();
        long winningCounter = winningCase.getOrDefault(key, 0L);
        DecimalFormat commaInMoney = new DecimalFormat("###,###");

        if (rank == WinningNumbers.FIVE_BONUS) {
            return matches + "개 일치, 보너스 볼 일치 (" + commaInMoney.format(reward) + "원) - " + winningCounter + "개";
        }

        return matches + "개 일치 (" + commaInMoney.format(reward) + "원) - " + winningCounter + "개";
    }

    private void printRewardRate(double rawRatio) {
        System.out.println("총 수익률은 "+ String.format("%.1f", rawRatio) + "%입니다.");
    }
}
