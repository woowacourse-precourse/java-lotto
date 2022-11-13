package lotto;

import java.util.List;

public class LottoGroups {
    private List<Lotto> lottos;

    public LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
