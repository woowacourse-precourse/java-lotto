package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.machine.Ranks;

import static lotto.Constants.*;

public class Output {
    private final static String PURCHASE_SUCCESSFUL = "개를 구매했습니다.";
    private final static String STATS_TITLE = "당첨 통계";
    private final static String HORIZONTAL_RULE = "---";
    private final static String ROI_HEAD = "총 수익률은 ";
    private final static String ROI_FOOTER = "%입니다.";
    private final static String COUNT_UNIT = " - %d개\n";

    public static final void purchaseSuccessful(Integer purchasePrice, List<List<Integer>> lottoTickets) {
        Integer purchaseQuantity = purchasePrice / UNIT_PRICE;

        System.out.println(purchaseQuantity + PURCHASE_SUCCESSFUL);
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static final void lottoResult(
            Integer purchasePrice,
            List<Integer> totalProfit,
            Map<Integer, Integer> statistics
    ) {
        System.out.println(STATS_TITLE);
        System.out.println(HORIZONTAL_RULE);
        for (Map.Entry<Integer, Integer> history : statistics.entrySet()) {
            printWinCount(history.getKey(), history.getValue());
        }
        printReturnOnInvestment(totalProfit, purchasePrice);
    }

    private static void printWinCount(Integer profit, Integer winCount) {
        Ranks ranks = Ranks.getRankBy(profit);
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
}
