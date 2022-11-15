package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;

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
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isSameRangeAsLottoNumber(int number) {
        return LottoConstants.LOTTO_MIN_NUMBER <= number && number <= LottoConstants.LOTTO_MAX_NUMBER;
    }
}
