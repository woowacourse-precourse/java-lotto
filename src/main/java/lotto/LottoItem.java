package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LottoItem implements Comparable<LottoItem>{
    private final int number;
    private static final String ERROR_NUMBER_RANGE = "로또 번호는 1 ~ 45 여야 합니다.";

    public LottoItem(int number) {
        validateRange(number);

        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    public int get() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoItem that = (LottoItem) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoItem o) {
        return 0;
    }
}
