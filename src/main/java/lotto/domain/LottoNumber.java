package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private static final String ERROR_NUMERIC_RANGE = String.format("로또 번호는 %d 부터 %d 숫자까지 가능합니다.",
            MIN_VALUE, MAX_VALUE);
    private static final List<LottoNumber> cache = new ArrayList<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            cache.add(new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        validateValueNumericRange(value);
        this.value = value;
    }

    public static LottoNumber getInstance(int value) {
        validateValueNumericRange(value);
        int cacheIndex = value - 1;
        return cache.get(cacheIndex);
    }

    private static void validateValueNumericRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_NUMERIC_RANGE);
        }
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

