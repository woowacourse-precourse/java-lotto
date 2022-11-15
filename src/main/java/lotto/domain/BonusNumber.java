package lotto.domain;

import lotto.constant.LottoConstants;

final class BonusNumber {
    private static final String OVER_RANGE_MESSAGE = "보너스 숫자에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE + "보다 큰 숫자가 올 수 없습니다";
    private static final String UNDER_RANGE_MESSAGE = "보너스 숫자에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE + "보다 큰 숫자가 올 수 없습니다";

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOverRange(number)) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
        if (isUnderRange(number)) {
            throw new IllegalArgumentException(UNDER_RANGE_MESSAGE);
        }
    }

    private boolean isOverRange(int number) {
        return number > LottoConstants.LOTTO_END_INCLUSIVE;
    }

    private boolean isUnderRange(int number) {
        return number < LottoConstants.LOTTO_START_INCLUSIVE;
    }

    public boolean isBonusNumber(int other) {
        return other == number;
    }
}
