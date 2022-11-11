package lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (hasLottoNumberRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasLottoNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
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
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.number, lottoNumber.getNumber());
    }
}
