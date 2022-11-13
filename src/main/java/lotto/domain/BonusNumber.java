package lotto.domain;

import lotto.constant.LottoConstants;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        isInRange(number);
    }

    private void isInRange(int number) {
        if (number < LottoConstants.LOTTO_START_INCLUSIVE.value()) {
            throw new IllegalArgumentException();
        }
        if (number > LottoConstants.LOTTO_END_INCLUSIVE.value()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isBonusNumber(int other) {
        return other == number;
    }
}
