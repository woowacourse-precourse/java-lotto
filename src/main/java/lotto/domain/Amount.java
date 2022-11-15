package lotto.domain;

public class Amount {
    private static final int UNIT = 1000;
    private static final String WRONG_UNIT_MESSAGE = String.format("[ERROR]: Not %d units.", UNIT);

    private final int money;

    public Amount(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (!validateRemainder(money)) {
            throw new IllegalArgumentException(WRONG_UNIT_MESSAGE);
        }
    }

    private boolean validateRemainder(int money) {
        return money != 0 && money % UNIT == 0;
    }

    public int getMoney() {
        return this.money;
    }

    public int getNumberOfLotto() {
        return this.money / UNIT;
    }
}
