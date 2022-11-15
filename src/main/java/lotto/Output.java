package lotto;

import java.util.Map;

public class Output {
    private final TicketHandler ticketHandler;

    public Output() {
        ticketHandler = new TicketHandler();
    }

    public void printTickets() {
        for (Lotto l : Application.getLotto()) {
            System.out.println(l.getNumbers());
        }
    }

    public void printWinnings() {
        System.out.println("당첨 통계\n---");
        int winnings = 0;
        for (Map.Entry<Winnings, Integer> m : Application.getWinningTickets().entrySet()) {
            System.out.println(m.getKey().getInfo() + m.getValue() + "개");
            winnings += (m.getKey().getAmount() * m.getValue());
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", ticketHandler.calcProfit(winnings));
    }
}
