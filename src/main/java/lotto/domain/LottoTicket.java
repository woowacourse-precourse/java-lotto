package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> get() {
        return lottoTicket;
    }
}
