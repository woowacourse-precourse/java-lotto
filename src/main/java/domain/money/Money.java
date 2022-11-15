package domain.money;

public class Money {
    private final static int ZERO = 0;
    private final static int UNIT = 1000;
    private final int money;

    public Money(int money) {
        validateZero(money);
        validateOneThousandUnit(money);
        this.money = money;

    }

    public void validateZero(int money) {
        if (money == ZERO) {
            throw new IllegalArgumentException("구매 금액은 0원 이상이어야 합니다.");
        }
    }

    public void validateOneThousandUnit(int money) {
        if (money % UNIT != ZERO) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
