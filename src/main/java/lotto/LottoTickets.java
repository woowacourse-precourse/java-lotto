package lotto;

import java.util.List;

public class LottoTickets {
    private List<Lotto> lottoTickets;

    LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoTicketsQuantity() {
        return lottoTickets.size();
    }
}
