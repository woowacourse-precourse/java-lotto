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
        for (int i = 0; i < totalLotteries.size(); i++) {
            List<Integer> lotto = totalLotteries.get(i);
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(int[] winningNumberMatchCount) {
        List<Integer> winningNumberMatchCounts = Arrays.stream(winningNumberMatchCount)
                .boxed().collect(Collectors.toList());
        int matchCount = 3;
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankMatchCount = Collections.frequency(winningNumberMatchCounts, matchCount);
            System.out.println(lottoRank.getValue() + " - " + rankMatchCount + "개");
            if (matchCount == 5) {
                matchCount = 7;
                continue;
            }
            if (matchCount == 7) {
                matchCount = 6;
                continue;
            }
            matchCount++;
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
