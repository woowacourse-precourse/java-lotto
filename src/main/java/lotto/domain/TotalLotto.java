package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalLotto {
    private final List<Lotto> lottos = new ArrayList<>();

    public TotalLotto(final List<Lotto> buyingLottos) {
        this.lottos.addAll(buyingLottos);
    }
}
