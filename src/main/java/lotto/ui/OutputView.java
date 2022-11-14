package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public enum OutputView {
    INSTANCE;
    private static final String PURCHASED_LOTTO_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "당첨 통계\n---";
    private static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.\n";

    public static void printLottoReceipts(List<Lotto> lotteries) {
        printPurchasedLottoQuantity(lotteries);
        printLotteries(lotteries);
    }

    public static void printTotalResult(List<String> rankInfoWithCounts, String yield) {
        System.out.println(TOTAL_RESULT_HEADER_MESSAGE);
        printRankInfoWithCounts(rankInfoWithCounts);
        printYield(yield);
    }

    private static void printPurchasedLottoQuantity(List<Lotto> lotteries) {
        System.out.printf(PURCHASED_LOTTO_QUANTITY_MESSAGE_FORMAT, lotteries.size());
    }

    private static void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
    }

    private static void printRankInfoWithCounts(List<String> rankInfoWithCounts) {
        rankInfoWithCounts.forEach(System.out::println);
    }

    private static void printYield(String yield) {
        System.out.printf(YIELD_MESSAGE_FORMAT, yield);
    }
}
