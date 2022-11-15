package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class OutputView {
    private static final String RESULT_INTRO = "\n당첨 통계";
    private static final String LINE = "---";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String TOTAL_LOTTO_BOUGHT_COUNT = "\n%d개를 구매했습니다.\n";

    public static void printResult(LottoResult lottoResult, double yield) {
        System.out.println(RESULT_INTRO);
        System.out.println(LINE);
        Map<Rank, Long> statistics = lottoResult.getStatistics();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printStaticsByRank(rank, statistics));
        System.out.printf(YIELD_MESSAGE, yield);
    }

    private static void printStaticsByRank(Rank rank, Map<Rank, Long> statistics) {
        int matchCounts = rank.getMatchCounts();
        String prize = rank.getPrizeMoneyFormat();
        long lottoCounts = statistics.get(rank);
        if (rank == Rank.SECOND_PRIZE) {
            System.out.printf(STATISTICS_BONUS_MESSAGE, matchCounts, prize, lottoCounts);
            return;
        }
        System.out.printf(STATISTICS_MESSAGE, matchCounts, prize, lottoCounts);
    }

    public static void printAllLottoNumbers(Lottos lottos) {
        System.out.printf(TOTAL_LOTTO_BOUGHT_COUNT, lottos.getLottoCounts());
        lottos.getLottos()
                .forEach(OutputView::printEachLottoNumber);
        System.out.println();
    }

    private static void printEachLottoNumber(Lotto lotto) {
        String numbers = lotto.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println(numbers);
    }
}
