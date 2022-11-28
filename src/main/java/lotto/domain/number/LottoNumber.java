package lotto.domain.number;

import java.util.Objects;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);

        this.number = number;
    }

    private void validateNumber(int number) {
        if (!isValidNumberRange(number)) {
            throw new IllegalArgumentException(
                    ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
        }
    }

    private boolean isValidNumberRange(int number) {
        return LottoConst.MIN_NUMBER_VALUE <= number && number <= LottoConst.MAX_NUMBER_VALUE;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
