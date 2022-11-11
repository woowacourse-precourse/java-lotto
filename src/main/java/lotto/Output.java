package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Output {
    // 상수는 추후 application으로 이동
    private final static String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String STATS_TITLE_MESSAGE = "당첨 통계";
    private static final String HORIZONTAL_RULE = "---";
    private static final String MATCHING_COUNT = " - %d개\n";
    private static final String ROI_MESSAGE = "총 수익률은 %.1f%%입니다.\n";



    public static final void purchaseSuccessful(Integer cost, List<List<Integer>> lottos) {
        Integer numberOfLottos = cost / 1000;
        System.out.println(numberOfLottos + PURCHASE_MESSAGE);
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static final void statistics(Integer cost, Map<Integer, Integer> statistics) {
        System.out.println(STATS_TITLE_MESSAGE);
        System.out.println(HORIZONTAL_RULE);

        double totalProfit = 0;
        for (Map.Entry<Integer, Integer> entry : statistics.entrySet()) {
            printWinCount(entry.getKey(), entry.getValue());
            totalProfit += (entry.getKey() * entry.getValue());
        }
        printReturnOnInvestment(cost, totalProfit);
    }

    private static void printWinCount(Integer prizeMoney, Integer matchingCount) {
        Ranks rank = Ranks.getRankBy(prizeMoney);
        String matchingCountMessage = rank.getMessage() + MATCHING_COUNT;
        System.out.printf(matchingCountMessage, matchingCount);
    }

    private static void printReturnOnInvestment(Integer cost, double totalProfit) {
        double returnOnInvestment = Math.round(((totalProfit / cost) * 100) * 10) / 10.0;
        System.out.printf(ROI_MESSAGE, returnOnInvestment);
    }
}
