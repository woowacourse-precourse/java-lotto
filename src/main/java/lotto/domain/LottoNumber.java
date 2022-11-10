package lotto.domain;

import lotto.utils.LottoValidator;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        LottoValidator.validateLottoNumber(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    public LottoNumber(int lottoNumber) {
        LottoValidator.validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
