package lotto;

import java.util.List;

public class LottoNumbers {

    private final List<Lotto> lottos;

    public LottoNumbers(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}