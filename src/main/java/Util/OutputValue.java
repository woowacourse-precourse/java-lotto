package Util;

import domain.Rank;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class OutputValue {

    public static final int PERCENT = 100;
    public static final String PROFIT_FORMAT = "%.1f";

    public static void printTicketsList(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printWinningCount(Map<Rank, Integer> count) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank key : Rank.values()) {
            System.out.println(key.getResultPrint() + count.get(key) + "개");
        }
    }

    public static void printProfit(Map<Rank, Integer> count, int money){
        String format = String.format(PROFIT_FORMAT, (double) getTotalProfit(count) / money * PERCENT);
        System.out.println("총 수익률은 "+ format +"%입니다.");
    }

    private static long getTotalProfit(Map<Rank, Integer> count) {
        return count.entrySet().stream()
                .mapToLong(money -> (long) money.getKey().getWinningMoney() * money.getValue())
                .sum();
    }
}
