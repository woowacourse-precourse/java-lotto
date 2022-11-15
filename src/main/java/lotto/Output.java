package lotto;

import java.util.Map;

/**
 * Handles all console outputs.
 *
 * @author Davin An
 * @version 1.0
 */
public class Output {

    private final TicketHandler ticketHandler;

    public Output() {
        ticketHandler = new TicketHandler();
    }


    /**
     * Prints out the lotto tickets the user has.
     */
    public void printTickets() {
        for (Lotto l : Application.getLotto()) {
            System.out.println(l.getNumbers());
        }
    }

    /**
     * Prints out the winnings and the profit the user made.
     */
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
