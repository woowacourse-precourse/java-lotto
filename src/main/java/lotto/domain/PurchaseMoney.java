package lotto.domain;

import java.util.Objects;

public class PurchaseMoney {

    private static final String PURCHASE_MONEY_ERROR_MESSAGE = "[ERROR] 구매 금액은 1000원 단위이어야 합니다.";
    private static final int PURCHASE_MONEY_UNIT = 1000;

    private final int purchaseMoney;

    public PurchaseMoney(final int purchaseMoney) {
        validatePositivePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validatePositivePurchaseMoney(final int purchaseMoney) {
        if (purchaseMoney < PURCHASE_MONEY_UNIT || purchaseMoney % PURCHASE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_ERROR_MESSAGE);
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getLottoCount() {
        return purchaseMoney / PURCHASE_MONEY_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseMoney purchaseMoney = (PurchaseMoney) o;

        return Objects.equals(purchaseMoney, purchaseMoney.purchaseMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseMoney);
    }
}
