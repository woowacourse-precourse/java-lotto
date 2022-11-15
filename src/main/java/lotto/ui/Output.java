package lotto.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.service.Ranks;
import lotto.service.Tickets;
import lotto.service.Calculator;

public class Output {
    private static final int INITIAL_COUNT = 0;
    private static final int ONE_DECIMAL_PLACE = 1;
    private static final String PURCHASE_SUCCESSFUL = "개를 구매했습니다.";
    private static final String STATS_TITLE = "당첨 통계";
    private static final String HORIZONTAL_RULE = "---";
    private static final String ROI_HEAD = "총 수익률은 ";
    private static final String ROI_FOOTER = "%입니다.";
    private static final String COUNT_UNIT = " - %d개\n";

    public static final void printPurchaseSuccessful(Tickets lottoTickets) {
        System.out.println(lottoTickets.getPurchaseQuantity() + PURCHASE_SUCCESSFUL);
        for (List<Integer> lotto : lottoTickets.getTickets()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static final void printStatistics(Calculator calculator, Integer purchasePrice) {
        System.out.println(STATS_TITLE);
        System.out.println(HORIZONTAL_RULE);

        final List<Integer> totalProfit = calculator.getTotalProfit();
        final Map<Integer, Integer> statistics = Statistics.getStatisticsBy(totalProfit);

        for (Map.Entry<Integer, Integer> history : statistics.entrySet()) {
            // key: a set of prize money for from 3 winning numbers to 6 winning numbers
            // values: updated counts of winning each prize money
            printHistory(history.getKey(), history.getValue());
        }
        printReturnOnInvestment(totalProfit, purchasePrice);
    }

    private static void printHistory(Integer prizeMoney, Integer winCount) {
        final Ranks ranks = Ranks.getRankBy(prizeMoney);
        final String message = ranks.getMessage() + COUNT_UNIT;
        System.out.printf(message, winCount);
    }

    private static void printReturnOnInvestment(List<Integer> totalProfit, Integer purchasePrice) {
        final double returnOnInvestment = getReturnOnInvestmentBy(totalProfit, purchasePrice);
        final BigDecimal returnOnInvestmentFormatted = formatNumber(returnOnInvestment);

        final StringBuilder message = new StringBuilder();
        message.append(ROI_HEAD);
        message.append(returnOnInvestmentFormatted);
        message.append(ROI_FOOTER);
        System.out.println(message);
    }

    private static double getReturnOnInvestmentBy(List<Integer> totalProfit, Integer purchasePrice) {
        final double sumOfTotalProfit = totalProfit.stream()
                .mapToInt(Integer::intValue)
                .sum();
        final double returnOnInvestment = (sumOfTotalProfit / purchasePrice) * 100;
        return returnOnInvestment;
    }

    private static BigDecimal formatNumber(double number) {
        return new BigDecimal(String.valueOf(number))
                .setScale(ONE_DECIMAL_PLACE, RoundingMode.HALF_EVEN);
    }

    private static class Statistics {
        private static Map<Integer, Integer> getStatisticsBy(List<Integer> totalProfit) {
            final int initialWinCount = INITIAL_COUNT;
            final Map<Integer, Integer> statistics = new LinkedHashMap<>();

            initialize(statistics, initialWinCount);
            update(statistics, totalProfit);
            return statistics;
        }

        private static void initialize(Map<Integer, Integer> statistics, int winCount) {
            for (Ranks ranks : Ranks.values()) {
                statistics.put(ranks.getPrizeMoney(), winCount);
            }
        }

        private static void update(Map<Integer, Integer> statistics, List<Integer> totalProfit) {
            for (Integer profit : totalProfit) {
                addWinCount(statistics, profit);
            }
        }

        private static void addWinCount(Map<Integer, Integer> statistics, Integer profit) {
            if (statistics.containsKey(profit)) {
                int winCount = statistics.get(profit);
                statistics.replace(profit, winCount + 1);
            }
        }
    }
}
