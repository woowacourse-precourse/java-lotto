package lotto.domain;

import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private int getCount(int purchasePrice) {
        return purchasePrice / LottoCondition.PRICE.getNumber();
    }
}
