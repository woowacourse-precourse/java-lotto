package lotto.domain;

public class LottoNumber {
    static final int RANGE_MINIMUM = 1;
    static final int RANGE_MAXIMUM = 45;
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE =
            "로또 번호는 " + RANGE_MINIMUM + "~" + RANGE_MAXIMUM + "의 범위 내에 있어야합니다";

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < RANGE_MINIMUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        if (number > RANGE_MAXIMUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LottoNumber that = (LottoNumber)o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
