package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.LottoGenerateStrategy;

public class Lottos {

    public List<Lotto> lottos = new ArrayList<>();

    public Lottos(int pieces, LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottos = makeLottos(pieces, lottoGenerateStrategy);
    }

    private List<Lotto> makeLottos(int pieces, LottoGenerateStrategy lottoGenerateStrategy) {
        for (int i = 0; i < pieces; i++) {
            Lotto lotto = new Lotto(lottoGenerateStrategy.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
