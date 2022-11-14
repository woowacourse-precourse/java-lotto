package lotto.model;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Lottos(List<Lotto> lottos, String purchaseAmountStr) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmountStringToInteger(purchaseAmountStr);
    }

    private int purchaseAmountStringToInteger(String purchaseAmountStr) {
        return Integer.parseInt(purchaseAmountStr);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
