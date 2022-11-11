package lotto;

public class Money {
    private static final int THOUSAND = 1_000;
    private static final int ZERO = 0;
    private int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void decreaseAmount(int value) {
        amount -= value;
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
