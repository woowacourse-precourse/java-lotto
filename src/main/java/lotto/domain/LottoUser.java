package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.createRandomLotto;
import static lotto.util.ConstValue.LottoConst.LOTTO_BASIC_COST;

public class LottoUser {

    private final List<Lotto> randomLottos;
    private final int purchaseCost;

    public LottoUser(final int purchaseCost) {
        randomLottos = new ArrayList<>();
        this.purchaseCost = purchaseCost;
        purchaseRandomLottos(purchaseCost);
    }

    private void purchaseRandomLottos(final int purchaseCost) {
        final int purchaseLottoCount = purchaseCost / LOTTO_BASIC_COST;
        for (int i = 0; i < purchaseLottoCount; i++) {
            randomLottos.add(createRandomLotto());
        }
    }
}
