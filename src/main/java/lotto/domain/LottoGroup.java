package lotto.domain;

import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}
