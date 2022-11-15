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

    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계\n---";
    private static final String DEFAULT_RANK_MATCH_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RANK_MATCH_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String TOTAL_YIELD_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private static final String EMPTY_STRING = "";
    private static final List<Rank> RANKS = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    public static void printPurchaseLottoCount(final LottoPurchaseResult result) {
        List<Lotto> lottos = result.getLottos();

        println(format(PURCHASE_MESSAGE_FORMAT, lottos.size()));

        lottos.forEach(lotto -> println(lotto.toString()));

        println(EMPTY_STRING);
    }

    public static void printStatistic(final WinningResult result) {
        Statistics statistics = result.getStatistics();

        println(WINNING_STATISTICS_TITLE);

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
                DEFAULT_RANK_MATCH_MESSAGE_FORMAT,
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private static void printSecondRank(final Rank rank, final Statistics statistics) {
        println(format(
                SECOND_RANK_MATCH_MESSAGE_FORMAT,
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private static void printYield(final Statistics statistics) {
        println(format(TOTAL_YIELD_MESSAGE_FORMAT, statistics.yield()));
    }
}
