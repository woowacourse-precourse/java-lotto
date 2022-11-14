package lotto.vo;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(final int  number) {
        this.number = number;
    }

    public int getLottoNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber lottoNumber = (LottoNumber) o;

        return Objects.equals(lottoNumber, lottoNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
