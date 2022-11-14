package lotto.domain;

import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private static final String NUMBER_RANGE_ERROR = "로또 숫자는 " + MIN + " 이상 " + MAX + " 이하의 숫자만 가능합니다.";

    private static final LottoNumber[] cacheLottoNumber = new LottoNumber[MAX + 1];

    private final int number;

    static {
        IntStream.range(MIN, MAX + 1)
                .forEach(i -> cacheLottoNumber[i] = new LottoNumber(i));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return cacheLottoNumber[number];
    }

    private static void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }

    public int toInt() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}