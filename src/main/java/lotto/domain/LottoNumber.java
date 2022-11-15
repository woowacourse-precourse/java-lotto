package lotto.domain;

import static lotto.domain.messages.ErrorMessages.RANGE_ERROR_MESSAGE;

public class LottoNumber {

    private static final Integer MAX_LOTTO_NUMBER = 45;
    private static final Integer MIN_LOTTO_NUMBER = 1;
    private Integer number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber generateFromRawValue(int inputNumber) {
        return new LottoNumber(inputNumber);
    }

    private void validate(int number) {
        validateTo45From1(number);
    }

    private void validateTo45From1(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return that.isSameNumber(this.number);
    }

    private boolean isSameNumber(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}



