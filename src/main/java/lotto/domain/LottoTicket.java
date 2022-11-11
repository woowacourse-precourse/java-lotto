package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private List<Lotto> ticket;

    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }

    public List<List<Integer>> value() {
        return ticket.stream()
                .map(Lotto::value)
                .collect(Collectors.toList());
    }
}
