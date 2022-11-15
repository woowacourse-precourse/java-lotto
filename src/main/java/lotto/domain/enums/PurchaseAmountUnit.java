package lotto.domain.enums;

public enum PurchaseAmountUnit {
    LOTTO_PURCHASE_UNIT(1000);

    private int unit;

    PurchaseAmountUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }

    public void validDivisionByThousand(int purchaseAmount) {
        if (purchaseAmount % unit != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int PurchaseAmount(int PurchaseAmount) {
        return PurchaseAmount / unit;
    }
}
