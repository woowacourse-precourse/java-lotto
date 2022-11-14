package lotto.domain.lotto;

import lotto.domain.lotto.util.Validate;

import java.util.Objects;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return this.lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lottoNumber);
    }
}
