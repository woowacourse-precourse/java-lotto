package lotto.ui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.service.Ranks;
import lotto.service.Tickets;
import lotto.service.Calculator;

public class Output {
    private static final int INITIAL_COUNT = 0;
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

        Statistics statistics = new Statistics(calculator.getTotalProfit());
        for (Map.Entry<Integer, Integer> history : statistics.getStatistics().entrySet()) {
            // key: a set of prize money for from 3 winning numbers to 6 winning numbers
            // values: counts of winning each prize money
            printHistory(history.getKey(), history.getValue());
        }
        printReturnOnInvestment(calculator.getTotalProfit(), purchasePrice);
    }

    private static void printHistory(Integer prizeMoney, Integer winCount) {
        Ranks ranks = Ranks.getRankBy(prizeMoney);
        String message = ranks.getMessage() + COUNT_UNIT;
        System.out.printf(message, winCount);
    }

    private static void printReturnOnInvestment(List<Integer> totalProfit, Integer purchasePrice) {
        double returnOnInvestment = getReturnOnInvestmentBy(totalProfit, purchasePrice);

        StringBuilder message = new StringBuilder();
        message.append(ROI_HEAD);
        message.append(returnOnInvestment);
        message.append(ROI_FOOTER);

        System.out.println(message);
    }

    private static double getReturnOnInvestmentBy(List<Integer> totalProfit, Integer purchasePrice) {
        double sumOfTotalProfit = totalProfit.stream()
                .mapToInt(Integer::intValue)
                .sum();
        double returnOnInvestment = (sumOfTotalProfit / purchasePrice) * 100;
        return roundOffToOneDecimalPlace(returnOnInvestment);
    }

    private static double roundOffToOneDecimalPlace(double number) {
        return Math.round((number) * 10) / 10.0;
    }

    private static class Statistics {
        private final Map<Integer, Integer> statistics;

        public Statistics(List<Integer> totalProfit) {
            statistics = createStatistics();
            updateStatistics(totalProfit);
        }

        public Map<Integer, Integer> getStatistics() {
            return statistics;
        }

        private Map<Integer, Integer> createStatistics() {
            int initialWinCount = INITIAL_COUNT;
            final Map<Integer, Integer> initialStatistics = new LinkedHashMap<>();

            for (Ranks ranks : Ranks.values()) {
                initialStatistics.put(ranks.getPrizeMoney(), initialWinCount);
            }
            return initialStatistics;
        }

        private void updateStatistics(List<Integer> totalProfit) {
            for (Integer profit : totalProfit) {
                updateWinCount(profit);
            }
        }

        private void updateWinCount(Integer profit) {
            if (statistics.containsKey(profit)) {
                int winCount = statistics.get(profit);
                statistics.replace(profit, winCount + 1);
            }
        }
    }
}
