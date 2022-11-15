package lotto.domain.lottomachine.ranking;

import java.math.BigDecimal;
import java.util.Objects;

import static lotto.domain.lottomachine.error.DomainErrorMessage.NEGATIVE_FREQUENCY;

public class Frequency {
    private final int frequency;

    private Frequency(int frequency) {
        validate(frequency);
        this.frequency = frequency;
    }

    public static Frequency from(int frequency) {
        return new Frequency(frequency);
    }

    private void validate(int frequency) {
        if (frequency < 0) {
            throw new IllegalArgumentException(NEGATIVE_FREQUENCY.getMessage());
        }
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
