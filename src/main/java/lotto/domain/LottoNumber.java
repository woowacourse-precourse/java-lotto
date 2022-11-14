package lotto.domain;

import lotto.domain.validutils.LottoNumberValidUtils;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private final int number;

    public LottoNumber(int number) {
        LottoNumberValidUtils.validateRange(number);
        this.number = number;
    }

    public int mapToInt() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.sub(lottoNumber);
    }

    private int sub(LottoNumber lottoNumber) {
        return number - lottoNumber.mapToInt();
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
