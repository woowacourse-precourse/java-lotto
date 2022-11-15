package lotto.controller.result;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoPurchaseResult {

    private final List<Lotto> lottos;

    public LottoPurchaseResult(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
