package lotto;

import util.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private static Map<String, Integer> winningTicketsCount = new HashMap<>();

    public WinningStatistics() {
        winningTicketsCount.put(Rank.FIRST.name(), 0);
        winningTicketsCount.put(Rank.SECOND.name(), 0);
        winningTicketsCount.put(Rank.THIRD.name(), 0);
        winningTicketsCount.put(Rank.FOURTH.name(), 0);
        winningTicketsCount.put(Rank.FIFTH.name(), 0);
        winningTicketsCount.put(Rank.MISS.name(), 0);
    }

    public static void setWinningTickets(int matchCount, boolean isSecond) {


        if (matchCount == Rank.FIRST.getMatchCount()) {
            winningTicketsCount.put(Rank.FIRST.name(), winningTicketsCount.get(Rank.FIRST.name()) + 1);
        } else if (matchCount == Rank.SECOND.getMatchCount() && isSecond == true) {
            winningTicketsCount.put(Rank.SECOND.name(), winningTicketsCount.get(Rank.SECOND.name()) + 1);
        } else if (matchCount == Rank.THIRD.getMatchCount() && isSecond == false) {
            winningTicketsCount.put(Rank.THIRD.name(), winningTicketsCount.get(Rank.THIRD.name()) + 1);
        } else if (matchCount == Rank.FOURTH.getMatchCount()) {
            winningTicketsCount.put(Rank.FOURTH.name(), winningTicketsCount.get(Rank.FOURTH.name()) + 1);
        } else if (matchCount == Rank.FIFTH.getMatchCount()) {
            winningTicketsCount.put(Rank.FIFTH.name(), winningTicketsCount.get(Rank.FIFTH.name()) + 1);
        } else if (matchCount < 3) {
            winningTicketsCount.put(Rank.MISS.name(), 0);
        }
    }


    public static void result() {
        System.out.println("당첨 통계 \n---");
        System.out.println(Rank.FIFTH.getResultMessage() + winningTicketsCount.get(Rank.FIFTH.name()) + "개");
        System.out.println(Rank.FOURTH.getResultMessage() + winningTicketsCount.get(Rank.FOURTH.name()) + "개");
        System.out.println(Rank.THIRD.getResultMessage() + winningTicketsCount.get(Rank.THIRD.name()) + "개");
        System.out.println(Rank.SECOND.getResultMessage() + winningTicketsCount.get(Rank.SECOND.name()) + "개");
        System.out.println(Rank.FIRST.getResultMessage() + winningTicketsCount.get(Rank.FIRST.name()) + "개");
    }

    public static long calculateProfit() {
        long profit = 0;
        for (String name : winningTicketsCount.keySet()) {
            int count = winningTicketsCount.get(name);
            profit += Rank.valueOf(name).getPrize() * count;
        }

        return profit;
    }

    public static void calculateProfitRate(int tickets) {
        int money = tickets * 1000;
        long profit = calculateProfit();

        double rate = (profit / (double) money) * 100;

        String profitRate = String.format("%.1f", rate);

        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
