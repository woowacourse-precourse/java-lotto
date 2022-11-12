package lotto.view;

import lotto.controller.result.LottoPurchaseResult;
import lotto.controller.result.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.rank.Rank;
import lotto.domain.statistics.Statistics;

import java.util.List;

import static java.lang.String.format;
import static lotto.domain.rank.Rank.*;
import static lotto.infra.port.outbound.StandardOutput.println;

public class OutputView {

    private static final List<Rank> RANKS = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    public static void printPurchaseLottoCount(final LottoPurchaseResult result) {
        List<Lotto> lottos = result.getLottos();

        println(format("%d개를 구매했습니다.", lottos.size()));

        lottos.forEach(lotto -> println(lotto.toString()));

        println("");
    }

    public static void printStatistic(final WinningResult result) {
        Statistics statistics = result.getStatistics();

        println("당첨 통계");
        println("---");

        RANKS.forEach(rank -> printRank(rank, statistics));

        printYield(statistics);
    }


    private static void printRank(final Rank rank, final Statistics statistics) {
        if (rank == SECOND) {
            printSecondRank(rank, statistics);
            return;
        }
        printDefaultRank(rank, statistics);
    }

    private static void printDefaultRank(final Rank rank, final Statistics statistics) {
        println(format(
                "%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private static void printSecondRank(final Rank rank, final Statistics statistics) {
        println(format(
                "%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private static void printYield(final Statistics statistics) {
        println(format("총 수익률은 %.1f%%입니다.", statistics.yield()));
    }
}
