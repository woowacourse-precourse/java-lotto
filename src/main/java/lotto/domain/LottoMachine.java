package lotto.domain;

public class LottoMachine {
    private static final int LOTTO_COST = 1000;

    public int calculatePurchasingPrice(Lottos lottos) {
        return lottos.getLottoCounts() * LOTTO_COST;
    }

    public Lottos issueLottos(PurchasingPrice purchasingPrice) {
        int purchasableLottoCounts = purchasingPrice.calculatePurchasableLottoCounts(LOTTO_COST);
        return Lottos.generate(purchasableLottoCounts);
    }
}
