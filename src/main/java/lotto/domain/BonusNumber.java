package lotto.domain;

import lotto.constant.LottoConstants;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOverRange(number)) {
            throw new IllegalArgumentException();
        }
        if (isUnderRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOverRange(int number) {
        return number <= LottoConstants.LOTTO_END_INCLUSIVE.value();
    }

    private boolean isUnderRange(int number) {
        return number >= LottoConstants.LOTTO_START_INCLUSIVE.value();
    }

    public boolean isBonusNumber(int other) {
        return other == number;
    }
}
