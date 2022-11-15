package lotto;

import java.util.ArrayList;
import java.util.List;

public class BoughtTicketsDTO   {

    private List<Lotto> tickets;

    public BoughtTicketsDTO(List<Lotto> boughtTickets) {
        tickets = new ArrayList<>();
        tickets.addAll(boughtTickets);
    }

    public List<Lotto> getTickets() {
        return (tickets);
    }
}
