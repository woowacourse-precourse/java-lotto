package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroups {
    private List<Lotto> lottos;

    public LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
