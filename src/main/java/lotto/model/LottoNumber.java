package lotto.model;

import java.util.HashMap;

public class LottoNumber {
    public static final int LOTTO_LOWER_BOUND = 1;
    public static final int LOTTO_UPPER_BOUND = 45;
    private static final HashMap<Integer, LottoNumber> CACHE = new HashMap<>();
    private static final String INVALID_NUMBER_MESSAGE = "1 ~ 45 사이의 값을 입력해주세요.";

    private final Integer number;

    static {
        for (int i = LOTTO_LOWER_BOUND; i <= LOTTO_UPPER_BOUND; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < LOTTO_LOWER_BOUND || LOTTO_UPPER_BOUND < number) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}
