package lotto.model;

import lotto.util.constants.LottoConstants;

public class Bonus {
    private int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (!isSameRangeAsLottoNumber(number)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_IS_NOT_SAME_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isSameRangeAsLottoNumber(int number) {
        return LottoConstants.LOTTO_NUMBER_MIN <= number && number <= LottoConstants.LOTTO_NUMBER_MAX;
    }
}
