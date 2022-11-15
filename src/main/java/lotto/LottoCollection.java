package lotto;

import java.util.List;

public class LottoCollection {
    private List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public List<Lotto> copyCollection(){
        return List.copyOf(lottos);
    }
}
