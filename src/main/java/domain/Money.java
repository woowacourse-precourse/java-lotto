package domain;

public class Money {
    private final static int UNIT = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
        validateOneThousandUnit();
    }

    public void validateOneThousandUnit() {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int availablePurchases() {
        return money / UNIT;
    }
}
