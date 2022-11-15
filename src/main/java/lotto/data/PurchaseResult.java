package lotto.data;

import lotto.data.Lotto;

import java.util.List;

public class PurchaseResult {
    private final int purchasedAmount;
    private final List<Lotto> purchasedLottos;

    public PurchaseResult(int purchasedAmount, List<Lotto> purchasedLottos) {
        this.purchasedAmount = purchasedAmount;
        this.purchasedLottos = purchasedLottos;
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
