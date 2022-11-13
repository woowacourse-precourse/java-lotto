package lotto.game.domain;

import static lotto.game.ExceptionHandler.*;

import java.util.regex.Pattern;

public class Money {
    private static final Pattern moneyPattern = Pattern.compile("^[1-9]\\d*$");
    public static final Money NO_MONEY = new Money(0);

    private final long value;

    private Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money of(long value) {
        return new Money(value);
    }

    public static Money of(String input) {
        if (!moneyPattern.matcher(input).matches()) {
            throwException(NUMBER_ONLY_MESSAGE);
        }
        return Money.of(Long.parseLong(input));
    }

    public static Money of(LottoGrade grade) {
        return Money.of(grade.getPrize());
    }

    private void validate(long value) {
        if (value % 1000 == 0) {
            return;
        }
        throwException(DIVISIBLE_1000_ONLY_MESSAGE);
    }

    public long getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
