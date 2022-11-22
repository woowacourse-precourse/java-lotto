package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final Set<List<Integer>> tickets;

    public LottoTickets(Set<List<Integer>> lottoTickets) {
        this.tickets = lottoTickets;
    }

    public Set<List<Integer>> getTickets() {
        return tickets;
    }
}
