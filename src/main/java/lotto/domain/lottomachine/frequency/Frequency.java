package lotto.domain.lottomachine.frequency;

import java.math.BigDecimal;
import java.util.Objects;

import static lotto.domain.lottomachine.error.DomainErrorMessage.NEGATIVE_FREQUENCY;

public class Frequency {
    private static final int ZERO = 0;
    private final int frequency;

    private Frequency(int frequency) {
        validate(frequency);
        this.frequency = frequency;
    }

    public static Frequency from(int frequency) {
        return new Frequency(frequency);
    }

    private void validate(int frequency) {
        if (isLessThanZero(frequency)) {
            throw new IllegalArgumentException(NEGATIVE_FREQUENCY.getMessage());
        }
    }

    private boolean isLessThanZero(int number) {
        return number < ZERO;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(frequency);
    }

    @Override
    public String toString() {
        return String.valueOf(frequency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Frequency frequency1 = (Frequency) o;
        return frequency == frequency1.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency);
    }
}
