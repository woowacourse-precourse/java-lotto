package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class User {

    private final int purchaseCount;
    private final List<Lotto> lottos;
    private final List<LottoRank> lottoRanks;

    public User(int purchaseAmount) {
        this.purchaseCount = purchaseAmount / Lotto.LOTTO_UNIT;
        this.lottos = new ArrayList<>(this.purchaseCount);
        this.lottoRanks = new ArrayList<>(this.purchaseCount);

        purchaseLottos();
    }

    private void purchaseLottos() {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.create();
            lottos.add(lotto);
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }
}
