package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class TicketHandler {
    Map<Winnings, Integer> winningTickets = new LinkedHashMap<>();

    public TicketHandler() {
        this.winningTickets.put(Winnings.FifthPlace, 0);
        this.winningTickets.put(Winnings.FourthPlace, 0);
        this.winningTickets.put(Winnings.ThirdPlace, 0);
        this.winningTickets.put(Winnings.SecondPlace, 0);
        this.winningTickets.put(Winnings.FirstPlace, 0);
    }
}
