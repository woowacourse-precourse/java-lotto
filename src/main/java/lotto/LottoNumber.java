package lotto;

import static lotto.ExceptionCode.INVALID_LOTTO_NUMBER_RANGE;

import java.util.Objects;

public class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int NO;

    LottoNumber(int no) {
        validate(no);
        this.NO = no;
    }

    private void validate(int no) {
        if (no < LOWER_BOUND || no > UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return NO == that.NO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NO);
    }
}
