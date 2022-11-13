package lotto.domain;

public class Money {
    private static final int unit = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        isPositive(amount);
        isMultipleOfUnit(amount);
    }

    private void isPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isMultipleOfUnit(int amount) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int ableToBuy() {
        return amount / unit;
    }
}
