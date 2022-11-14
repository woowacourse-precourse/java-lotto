package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MINIMUM = 1;
    public static final int MAXIMUM = 45;
    public static final String OUT_OF_RANGE = "[ERROR] " + MINIMUM + "~" + MAXIMUM + "범위를 벗어난 숫자가 있습니다.";
    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    public static LottoNumber toLottoNumber(int number) {
        return new LottoNumber(number);
    }

    private void checkRange(int number) {
        if (isUnderMin(number) || isOverMax(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private boolean isUnderMin(int number) {
        if (number < MINIMUM) {
            return true;
        }
        return false;
    }

    private boolean isOverMax(int number) {
        if (number > MAXIMUM) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber lotto) {
        if (this.number > lotto.number) {
            return 1;
        } else if (this.number < lotto.number) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
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
