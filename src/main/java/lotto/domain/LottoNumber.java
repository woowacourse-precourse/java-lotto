package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.exception.domain.LottoNumberRangeException;

public class LottoNumber {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final Map<Integer, LottoNumber> lottoNumberCash;

    private final int number;

    static {
        lottoNumberCash = new HashMap<>();
        for (int number = LOTTO_NUMBER_MIN; number <= LOTTO_NUMBER_MAX; number++) {
            lottoNumberCash.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumberRange(number);
        return lottoNumberCash.get(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new LottoNumberRangeException(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        }
    }
}
