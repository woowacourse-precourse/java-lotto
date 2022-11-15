package lotto;

import static lotto.constant.Rules.END_INCLUSIVE;
import static lotto.constant.Rules.START_INCLUSIVE;

import lotto.exception.LottoNumberException;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!verifyRange(number)) {
            throw new LottoNumberException();
        }
    }

    private boolean verifyRange(int number) {
        return verifyMoreThanStartInclusive(number) && verifyLessOrEqualThanEndInclusive(number);
    }

    private boolean verifyMoreThanStartInclusive(int number) {
        return number >= START_INCLUSIVE;
    }

    private boolean verifyLessOrEqualThanEndInclusive(int number) {
        return number <= END_INCLUSIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public int getNumber() {
        return number;
    }
}
