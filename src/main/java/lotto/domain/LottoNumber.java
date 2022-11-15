package lotto.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber lottoNumber(int number) {
        return lottoNumbers.get(number);
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

    @Override
    public String toString() {
        return "" + number + "";
    }

    public int getNumber() {
        return number;
    }
}
