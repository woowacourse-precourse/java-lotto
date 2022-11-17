package lotto.domain.model;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public Lotto getLotto(int index) {
        return this.lottos.get(index);
    }

}
