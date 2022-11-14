package lotto.domain.number;

import lotto.resource.message.ErrorMessage;

import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final Number number;

    public LottoNumber(Number number) {
        validateRange(number);
        this.number = number;
    }

    public LottoNumber(int number) {
        this(new Number(number));
    }

    public LottoNumber(String number) {
        this(new Number(number));
    }

    private void validateRange(Number number) {
        if (number.getValueAsInt() < MINIMUM_NUMBER || number.getValueAsInt() > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_NOT_BETWEEN_1_AND_45_MESSAGE.getValue());
        }
    }

    public int getValueAsInt() {
        return number.getValueAsInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number.getValueAsInt());
    }
}
