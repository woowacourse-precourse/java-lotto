package lotto.lotto;

import static lotto.constant.Rules.END_INCLUSIVE;
import static lotto.constant.Rules.START_INCLUSIVE;

import java.util.Objects;
import lotto.exception.lotto.LottoNumberException;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String number) {
        int value = convertToInt(number);
        validate(value);
        this.number = value;
    }

    private void validate(int number) {
        if (!verifyRange(number)) {
            throw new LottoNumberException();
        }
    }

    private int convertToInt(String number) {
        if (!verifyPositiveInteger(number)) {
            throw new LottoNumberException();
        }
        return Integer.parseInt(number);
    }

    private boolean verifyPositiveInteger(String number) {
        return number != null && number.matches("^[1-9]\\d*");
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

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
