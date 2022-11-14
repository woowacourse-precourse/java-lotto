package lotto.domain;

import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottos) {
        this.lottoGroup = lottos;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}
