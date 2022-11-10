package lotto;

public class Money {
    private static final int THOUSAND = 1_000;
    private static final int ZERO = 0;

    public Money(int amount) {
        validate(amount);
    }

    private void validate(int amount) {
        if (amount % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
