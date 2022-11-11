package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
    private static final String INVALID_RANGE_MESSAGE = "[ERROR] 로또 번호의 허용된 범위를 벗어났습니다.";

    static {
        for (int i = LOTTO_NUMBER_LOWER_BOUND; i <= LOTTO_NUMBER_UPPER_BOUND; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private Integer number;

    private LottoNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    public Integer value() {
        return number;
    }

    public static LottoNumber valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || LOTTO_NUMBER_UPPER_BOUND < number) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }
}
