package lotto.domain;

import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.wons(0);

    private final Long value;

    public Money(Long value) {
        this.value = value;
    }

    public static Money wons(long value) {
        return new Money(value);
    }

    public Money plus(Money amount) {
        return new Money(this.value + amount.value);
    }

    public double divide(Money amount) {
        return this.value / (double) amount.value;
    }

    public Long getValue() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Money)) {
            return false;
        }

        Money object = (Money) o;
        return Objects.equals(value.doubleValue(), object.value.doubleValue());
    }

    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value + "원";
    }
}
