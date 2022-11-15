package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int purchaseNumber) {
        this.lottos = createLottos(purchaseNumber);
    }

    private List<Lotto> createLottos(int purchaseNumber) {
        List<Lotto> lottos = new ArrayList<>();
        LottoFactory lottoFactory = new LottoFactory();

        for (int i = 0; i < purchaseNumber; i++) {
            Lotto lotto = lottoFactory.createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getLottosCount() {
        return lottos.size();
    }
}
