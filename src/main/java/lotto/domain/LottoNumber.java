package lotto.domain;

import java.util.Objects;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);

        this.number = number;
    }

    private void validateNumber(int number) {
        if (!(LottoNumberConst.MIN_NUMBER_INT_VALUE <= number && number <= LottoNumberConst.MAX_NUMBER_INT_VALUE)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE.findExceptionMessage(number));
        }
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        LottoNumber targetLottoNumber = (LottoNumber) target;
        return this.number == targetLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
