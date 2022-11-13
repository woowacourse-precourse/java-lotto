package utils;

import lotto.Lotto;
import lotto.Lottos;
import lotto.WinningStatistic;
import lotto.Wins;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class OutputUtils {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATS_GUIDE = "당첨 통계\n---";
    private static final String MATCH_COUNT = "%d개 일치";
    private static final String MATCH_BONUS = ", 보너스 볼 일치";
    private static final String WINNINGS_AND_COUNT = " (%s원) - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final DecimalFormat decFormat = new DecimalFormat("###,###");

    public static void printLottoPurchaseCount(int purchaseCount) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, purchaseCount));
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStats(WinningStatistic winningStat) {
        StringBuilder result = new StringBuilder();
        Map<Wins, Integer> winningResult = winningStat.getWinningResult();

        System.out.println(WINNING_STATS_GUIDE);
        for (Wins win : Wins.values()) {
            if (win == Wins.OTHER) { continue; }

            result.append(String.format(MATCH_COUNT, win.getCount()));
            if (win.isBonus()) {
                result.append(String.format(MATCH_COUNT, win.getCount()));
            }
            String formattedWinnings = decFormat.format(win.getWinnings());
            int count = winningResult.get(win);
            result.append(String.format(WINNINGS_AND_COUNT, formattedWinnings, count));
        }

        System.out.println(result);
    }

    public static void printCalculatedProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
