package lotto.domain;

public class Money {

    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "금액은 음수이면 안됩니다";

    private final long amount;

    public Money(long amount) {
        validateGreaterThanZero(amount);
        this.amount = amount;
    }

    private void validateGreaterThanZero(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    public boolean hasChangesWith(long price) {
        return amount % price != 0;
    }

    public long countAffordableFor(long price) {
        return amount / price;
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Money money = (Money)o;

        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return (int)(amount ^ (amount >>> 32));
    }
}
