package lotto;

import java.util.List;

public class BoughtTicketsDTO   {

    private List<Lotto> tickets;

    public BoughtTicketsDTO(List<Lotto> boughtTickets) {
        tickets.addAll(boughtTickets);
    }

    public List<Lotto> getTickets() {
        return (tickets);
    }
}
