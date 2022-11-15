package lotto.domain;

import lotto.domain.exception.IllegalArgumentException;

import static lotto.domain.exception.ErrorType.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.domain.Lotto.LOTTO_END_NUMBER;
import static lotto.domain.Lotto.LOTTO_START_NUMBER;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validateNumberInRange(number, LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        this.number = number;
    }

    private void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}