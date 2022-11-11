package lotto.domain.lottomachine.lottoticket;

import java.util.List;

public class LottoTickets {

    private List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int size() {
        return tickets.size();
    }
}
