package view;

import lotto.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printLotteries(List<List<Integer>> totalLotteries) {
        int LotteriesSize = totalLotteries.size();
        for (int i = 0; i < LotteriesSize; i++) {
            List<Integer> lottery = totalLotteries.get(i);
            System.out.println(lottery);
        }
        System.out.println();
    }

    public static void printResult(int[] winningNumberMatchCount) {
        List<Integer> winningNumberMatchCounts = Arrays.stream(winningNumberMatchCount)
                .boxed().collect(Collectors.toList());
        int winningCount = 3;
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankMatchCount = Collections.frequency(winningNumberMatchCounts, winningCount);
            System.out.println(lottoRank.getValue() + " - " + rankMatchCount + "개");
            if (winningCount == 5) {
                winningCount = 7;
                continue;
            }
            if (winningCount == 7) {
                winningCount = 6;
                continue;
            }
            winningCount++;
        }
    }

    public static void printWinningMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
