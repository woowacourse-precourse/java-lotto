package lotto;

import java.util.List;

public class Print {
    public static void printPurchase(int ticketAmount, List<List<Integer>> ticketList) {
        System.out.println("\n" + ticketAmount + "개를 구매했습니다.");
        for (List<Integer> ticket : ticketList) {
            System.out.println(ticket);
        }
    }
}
