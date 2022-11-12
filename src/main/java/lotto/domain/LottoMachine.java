package lotto.domain;

public class LottoMachine {
    private final int LOTTO_UNIT = 1000;

    public Lottos purchase(PurchaseMoney purchaseMoney) {
        int purchaseNumber = countPurchaseNumber(purchaseMoney);

        return new Lottos(purchaseNumber);
    }

    private int countPurchaseNumber(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getPrice() / LOTTO_UNIT;
    }
}
