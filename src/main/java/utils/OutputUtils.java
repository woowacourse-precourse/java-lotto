package utils;

import lotto.Lotto;

import java.util.List;

public class OutputUtils {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계\n---";

    public static void printLottoPurchaseCount(int purchaseCount) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, purchaseCount));
    }

    public static void printPurchasedLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printCalculateWins() {
        System.out.println(WINNING_STATS);
    }

    public static void printWinningStats(String winningStats) {
        System.out.println(winningStats);
    }
}
