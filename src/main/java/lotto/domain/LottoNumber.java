package lotto.domain;


import lotto.LottoInputException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < MIN || number > MAX) {
            throw new LottoInputException("[ERROR]");
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
}
