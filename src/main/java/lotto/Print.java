package lotto;

import java.util.List;

public class Print {
    public static void printPurchase(int ticketAmount, List<List<Integer>> ticketList) {
        System.out.println("\n" + ticketAmount + "개를 구매했습니다.");
        for (List<Integer> ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    public static void printResult(int[] rankResults, double yield) {
        System.out.println("\n당첨 통계\n---");
        printRankResult(Rank.FIFTH.ballCount(), Rank.FIFTH.prizeMoney(), rankResults[4]);
        printRankResult(Rank.FOURTH.ballCount(), Rank.FOURTH.prizeMoney(), rankResults[3]);
        printRankResult(Rank.THIRD.ballCount(), Rank.THIRD.prizeMoney(), rankResults[2]);
        printRankResult(Rank.SECOND.ballCount(), Rank.SECOND.prizeMoney(), rankResults[1]);
        printRankResult(Rank.FIRST.ballCount(), Rank.FIRST.prizeMoney(), rankResults[0]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private static void printRankResult(String ballCount, int prizeMoney, int rankResult) {
        System.out.printf("%s (%,d원) - %d개\n", ballCount, prizeMoney, rankResult);
    }
}
