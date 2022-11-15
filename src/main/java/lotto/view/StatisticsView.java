package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.vo.Statistics;

public class StatisticsView {

    private static final double PERCENT_MULTIPLIER = 100.0;
    private static final String STATISTICS_BEGIN_MESSSAGE = "당첨 통계" + System.lineSeparator() + "---";
    private static final String STATISTIC_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String STATISTIC_FORMAT_WITH_BONUS_NUMBER = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printStatistics(Statistics statistics, Money capital) {
        System.out.println(STATISTICS_BEGIN_MESSSAGE);
        for (Rank rank : getRanksToPrint()) {
            printStatistic(rank, statistics.getCountOf(rank));
        }
        printProfitRate(capital, statistics.getTotalProfit());
    }

    private static List<Rank> getRanksToPrint() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static void printStatistic(Rank rank, int lottoCount) {
        int matchCount = rank.getMatchCount();
        Money prize = rank.getPrize();
        if (!rank.hasBonusNumber()) {
            System.out.printf(STATISTIC_FORMAT, matchCount, formatWithComma(prize), lottoCount);
        }
        if (rank.hasBonusNumber()) {
            System.out.printf(STATISTIC_FORMAT_WITH_BONUS_NUMBER, matchCount, formatWithComma(prize), lottoCount);
        }
        System.out.println();
    }

    private static void printProfitRate(Money capital, Money profit) {
        double profitRate = capital.calculateProfitRateOf(profit);
        System.out.printf(PROFIT_RATE_FORMAT, convertRateToPercentage(profitRate));
    }

    private static double convertRateToPercentage(double rate) {
        return rate * PERCENT_MULTIPLIER;
    }

    private static String formatWithComma(Money prize) {
        return NumberFormat.getInstance()
                .format(prize.getAmount());
    }
}
