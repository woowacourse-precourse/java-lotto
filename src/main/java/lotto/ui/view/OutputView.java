package lotto.ui.view;

import lotto.ui.message.OutputMessageGenerator;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.controller.TotalResult;

import java.util.List;
import java.util.Map;

public enum OutputView {
    INSTANCE;
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "당첨 통계\n---";

    public static void printLottoReceipts(List<Lotto> lotteries) {
        printPurchaseLottoMessage(lotteries);
        printLotteries(lotteries);
    }

    public static void printTotalResult(TotalResult totalResult) {
        System.out.println(TOTAL_RESULT_HEADER_MESSAGE);
        printTotalRankCountMessage(totalResult.getRankCounts());
        printYieldMessage(totalResult.getYield());
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

    private static void printTotalRankCountMessage(Map<Rank, Integer> rankCounts) {
        OutputMessageGenerator.getTotalRankCountMessage(rankCounts)
                .forEach(System.out::println);
    }

    private static void printYieldMessage(String yield) {
        System.out.println(OutputMessageGenerator.getYieldMessage(yield));
    }
}
