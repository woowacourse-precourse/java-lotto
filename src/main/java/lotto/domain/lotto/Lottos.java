package lotto.domain.lotto;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSizeOfLottoLines() {
        return this.lottos.size();
    }
}
