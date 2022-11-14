package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또의 번호는 1에서 45의 수이어야 합니다.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        validatePositiveLottoNumber(number);
        this.number = number;
    }

    private void validatePositiveLottoNumber(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
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
