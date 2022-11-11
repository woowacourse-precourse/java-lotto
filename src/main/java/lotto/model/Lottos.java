package lotto.model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int countLottos() {
        return this.lottos.size();
    }


}
