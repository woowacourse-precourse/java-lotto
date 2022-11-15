package lotto.domain;

import lotto.utils.Constant;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(Constant.ERROR_OUT_OF_RANGE_NUMBER);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < Constant.MIN_NUMBER || number > Constant.MAX_NUMBER;
    }
}