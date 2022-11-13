package lotto.domain;

public final class Money {
    private static final int unit = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        //Todo: 메시지 추가
        if (!isPositive(amount)) {
            throw new IllegalArgumentException();
        }
        if (!isMultipleOfUnit(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPositive(int amount) {
        return amount > 0;
    }

    private boolean isMultipleOfUnit(int amount) {
        return amount % unit == 0;
    }

    public int ableToBuy() {
        return amount / unit;
    }
}
