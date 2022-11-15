package lotto.domain.lottomachine.ranking;

import java.math.BigDecimal;

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
            throw new IllegalArgumentException("[ERROR] 빈도는 음수가 될 수 없습니다.");
        }
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(frequency);
    }

    @Override
    public String toString() {
        return String.valueOf(frequency);
    }
}
