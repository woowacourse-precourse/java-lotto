package lotto;

import java.util.List;

public class OutputView {
    public static void printTickets(List<List<Integer>> tickets){
        System.out.println(tickets.size() + Constant.PURCHASE_MESSAGE);
        tickets.stream().forEach(System.out::println);
        System.out.println();
    }
    private static void printReward(){

    }

    public static void printProfitRate(int profit, int cost){
        profit = profit / Constant.PURCHASE_UNIT;
        cost = cost / Constant.PURCHASE_UNIT;
        double result = ((double)(profit * 100)) / ((double)cost);
        String rateFormat = String.format("%.1f", result);
        System.out.println("총 수익률은 " + rateFormat + "%입니다.");
    }
}
