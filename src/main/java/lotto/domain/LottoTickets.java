package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
