package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public enum OutputView {
    INSTANCE;
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "당첨 통계\n---";
    private static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.\n";

    public static void printLottoReceipts(List<Lotto> lotteries) {
        printPurchaseLottoMessage(lotteries);
        printLotteries(lotteries);
    }

    public static void printTotalResult(List<String> rankInfoWithCounts, String yield) {
        System.out.println(TOTAL_RESULT_HEADER_MESSAGE);
        printRankInfoWithCounts(rankInfoWithCounts);
        printYield(yield);
    }

    private static void printPurchaseLottoMessage(List<Lotto> lotteries) {
        int lottoCnt = lotteries.size();
        System.out.println(OutputMessageGenerator.getPurchaseLottoMessage(lottoCnt));
    }

    private static void printLotteries(List<Lotto> lotteries) {
        lotteries.stream()
                .map(OutputMessageGenerator::getLottoNumbersByAscendingOrder)
                .forEach(System.out::println);
    }

    private static void printRankInfoWithCounts(List<String> rankInfoWithCounts) {
        rankInfoWithCounts.forEach(System.out::println);
    }

    private static void printYield(String yield) {
        System.out.printf(YIELD_MESSAGE_FORMAT, yield);
    }
}
