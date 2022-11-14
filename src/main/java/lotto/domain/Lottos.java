package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.LottoGenerateStrategy;

public class Lottos {

    private static final int FIRST_INDEX = 0;

    public List<Lotto> lottos = new ArrayList<>();

    public Lottos(int pieces, LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottos = makeLottos(pieces, lottoGenerateStrategy);
    }

    private List<Lotto> makeLottos(int pieces, LottoGenerateStrategy lottoGenerateStrategy) {
        for (int i = FIRST_INDEX; i < pieces; i++) {
            Lotto lotto = new Lotto(lottoGenerateStrategy.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
