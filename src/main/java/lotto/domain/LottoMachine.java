package lotto.domain;

import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos;

    public LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
