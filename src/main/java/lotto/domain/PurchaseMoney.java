package lotto.domain;

import java.util.Objects;

public class PurchaseMoney {

    private static final String PURCHASE_MONEY_ERROR_MESSAGE = "[ERROR] 구매 금액은 1000원 단위이어야 합니다.";
    private static final String EXCEEDED_PURCHASE_MONEY_ERROR_MESSAGE = "[ERROR] 구매 금액은 최대 10만 원까지 가능합니다.";
    private static final int MAX_PURCHASE_MONEY = 100000;
    private static final int PURCHASE_MONEY_UNIT = 1000;
    private static final int ZERO = 0;

    private final int purchaseMoney;

    public PurchaseMoney(final int purchaseMoney) {
        validatePositivePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validatePositivePurchaseMoney(final int purchaseMoney) {
        if (purchaseMoney < PURCHASE_MONEY_UNIT || purchaseMoney % PURCHASE_MONEY_UNIT != ZERO) {
            throw new IllegalArgumentException(PURCHASE_MONEY_ERROR_MESSAGE);
        }

        if (purchaseMoney > MAX_PURCHASE_MONEY) {
            throw new IllegalArgumentException(EXCEEDED_PURCHASE_MONEY_ERROR_MESSAGE);
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
