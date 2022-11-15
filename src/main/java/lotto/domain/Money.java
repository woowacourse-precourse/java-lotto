package lotto.domain;

import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.wons(0);

    private final Long amount;

    public Money(Long amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(amount);
    }

    public Money plus(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money times(long count) {
        return new Money(this.amount * count);
    }

    public double divide(Money other) {
        return this.amount / (double) other.amount;
    }

    public long floorDivide(Money other) {
        return Math.floorDiv(this.amount, other.amount);
    }

    public Money calculateRemainder(Money other) {
        return new Money(this.amount % other.amount);
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public Long getAmount() {
        return amount;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Money)) {
            return false;
        }

        Money object = (Money) o;
        return Objects.equals(amount, object.amount);
    }

    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount + "원";
    }
}
