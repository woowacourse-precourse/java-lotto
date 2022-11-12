package lotto;

import java.util.List;
import java.util.Map;

import static lotto.Constants.*;

public class Output {
    private final static String PURCHASE_SUCCESSFUL = "개를 구매했습니다.";
    private final static String STATS_TITLE = "당첨 통계";
    private final static String HORIZONTAL_RULE = "---";
    private final static String ROI_HEAD = "총 수익률은 ";
    private final static String ROI_FOOTER = "%입니다.";

    public static final void purchaseSuccessful(Integer purchasePrice, List<List<Integer>> lottoTickets) {
        Integer numberOfLottoTickets = purchasePrice / UNIT_PRICE;
        System.out.println(numberOfLottoTickets + PURCHASE_SUCCESSFUL);
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static final void statistics(Integer purchasePrice, Map<Integer, Integer> statistics) {
        System.out.println(STATS_TITLE);
        System.out.println(HORIZONTAL_RULE);

        double totalProfit = 0;
        for (Map.Entry<Integer, Integer> entry : statistics.entrySet()) {
            printWinCount(entry.getKey(), entry.getValue());
            totalProfit += (entry.getKey() * entry.getValue());
        }
        printReturnOnInvestment(purchasePrice, totalProfit);
    }

    private static void printWinCount(Integer prizeMoney, Integer winCount) {
        String countUnit = " - %d개\n";
        Ranks rank = Ranks.getRankBy(prizeMoney);
        String message = rank.getMessage() + countUnit;
        System.out.printf(message, winCount);
    }

    private static void printReturnOnInvestment(Integer purchasePrice, double totalProfit) {
        double returnOnInvestment = (totalProfit / purchasePrice) * 100;
        double roundedOffToOneDecimalPlace = Math.round((returnOnInvestment) * 10) / 10.0;

        StringBuilder message = new StringBuilder();
        message.append(ROI_HEAD);
        message.append(roundedOffToOneDecimalPlace);
        message.append(ROI_FOOTER);
        System.out.println(message);
    }
}
