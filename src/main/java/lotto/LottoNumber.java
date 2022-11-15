package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();
    private final int number;

    static {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber getInstance(int number) {
        validate(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }

    private static void validate(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR]");
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return java.lang.Integer.compare(number, o.get());
    }

    private int get() {
        return this.number;
    }

    public static Map<Integer, LottoNumber> getLottoNumberCache() {
        return LOTTO_NUMBER_CACHE;
    }
}
