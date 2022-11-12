package lotto.model;

import java.util.Objects;
import lotto.util.LottoExceptionMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String bonusNumber) {
        validate(bonusNumber);
        this.number = Integer.parseInt(bonusNumber);
    }

    private void validate(int number) {
        if (!hasLottoNumberRange(number)) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validate(String bonusNumber) {
        if (!hasNumber(bonusNumber) || !hasLottoNumberRange(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasLottoNumberRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
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
