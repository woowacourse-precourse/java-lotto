package lotto;

import java.util.List;

public class Print {
    public static void printTicketAmount(int ticketAmount) {
        System.out.println(ticketAmount + "개를 구매했습니다.");
    }

    public static void printTicketList(List<List<Integer>> ticketList) {
        for (int i = 0; i < ticketList.size(); i++) {
            List<Integer> ticket = ticketList.get(i);
            System.out.print("[");
            System.out.print(ticket.get(0));
            for (int j = 1; j < ticket.size(); j++) {
                System.out.print(", ");
                System.out.print(ticket.get(j));
            }
            System.out.println("]");
        }
    }
}
