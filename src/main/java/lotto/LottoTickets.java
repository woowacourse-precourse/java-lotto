package lotto;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
