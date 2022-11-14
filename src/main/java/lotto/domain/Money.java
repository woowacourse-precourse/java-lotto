package lotto.domain;

public class Money {
    private final long amount;

    public Money(long amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }

    private void validateNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다");
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

    public double calculateProfitRateOf(Money profit) {
        return (double)profit.amount / amount * 100.0;
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
