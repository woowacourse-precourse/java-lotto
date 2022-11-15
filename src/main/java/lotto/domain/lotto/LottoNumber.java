package lotto.domain.lotto;

import lotto.exception.lotto.LottoNumRangeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber getInstance(final int value) {
        validate(value);
        return CACHE.get(value);
    }

    private static void validate(final int value) {
        if (value < MIN || value > MAX) {
            throw new LottoNumRangeException(value);
        }
    }

    public static Map<Integer, LottoNumber> getCache() {
        return Map.copyOf(CACHE);
    }

    public int get() {
        return this.value;
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
        return value + "";
    }

    @Override
    public int compareTo(LottoNumber o) {
        return java.lang.Integer.compare(value, o.get());
    }
}
