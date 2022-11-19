package view;

import lotto.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static int winningCount;

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

    public static void printWinningResult(int[] winningNumberCount) {
        List<Integer> winningCountList = Arrays.stream(winningNumberCount)
                .boxed().collect(Collectors.toList());
        winningCount = 3;
        for (LottoRank lottoRank : LottoRank.values()) {
            int winningCountByRank = Collections.frequency(winningCountList, winningCount);
            System.out.println(lottoRank.getWinningCount() + " " + lottoRank.getWinningPrice()
                    + " - " + winningCountByRank + "개");
            changeWinningCount(winningCountList);
        }
    }

    public static int changeWinningCount(List<Integer> winningCountList) {
        winningCount++;
        if (winningCount == 7) {
            winningCount = 6;
        }
        if (winningCount == 6) {
            winningCount = 7;
        }
        return winningCount;
    }

    public static void printWinningMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
