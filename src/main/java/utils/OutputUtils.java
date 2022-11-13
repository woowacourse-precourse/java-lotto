package utils;

import lotto.Lotto;
import lotto.Lottos;

import java.util.List;

public class OutputUtils {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoPurchaseCount(int purchaseCount) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, purchaseCount));
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStats(String winningStats) {
        System.out.println(WINNING_STATS);
        System.out.println(winningStats);
    }

    public static void printCalculatedProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
