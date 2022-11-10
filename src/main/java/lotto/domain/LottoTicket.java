package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(this.lottos);
    }
}
