package lotto.domain;

import static lotto.domain.Lotto.LOTTO_END_NUMBER;
import static lotto.domain.Lotto.LOTTO_START_NUMBER;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateNumberInRange(number, LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        this.number = number;
    }

    private void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException();
        }
    }

    private int getNumber() {
        return number;
    }
}