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

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public Money times(long count) {
        return new Money(this.amount * count);
    }

    public double divide(Money amount) {
        return this.amount / (double) amount.amount;
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
        return Objects.equals(amount.doubleValue(), object.amount.doubleValue());
    }

    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount + "원";
    }
}
