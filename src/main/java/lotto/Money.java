package lotto;

public class Money {
    private static final int THOUSAND = 1_000;
    private static final int ZERO = 0;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public Money decreaseAmount(int value) {
        return new Money(amount - value);
    }

    private void validate(int amount) {
        if (amount % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
