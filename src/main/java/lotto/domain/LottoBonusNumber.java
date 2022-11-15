package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.exception.domain.LottoBonusNumberRangeException;

public class LottoBonusNumber {
    private static final int LOTTO_BONUS_NUMBER_MIN = 1;
    private static final int LOTTO_BONUS_NUMBER_MAX = 45;
    private static final Map<Integer, LottoBonusNumber> lottoBonusNumberCash;

    private final int number;

    static {
        lottoBonusNumberCash = new HashMap<>();
        for (int number = LOTTO_BONUS_NUMBER_MIN; number <= LOTTO_BONUS_NUMBER_MAX; number++) {
            lottoBonusNumberCash.put(number, new LottoBonusNumber(number));
        }
    }

    private LottoBonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static LottoBonusNumber of(int number) {
        validateNumberRange(number);
        return lottoBonusNumberCash.get(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_BONUS_NUMBER_MIN || number > LOTTO_BONUS_NUMBER_MAX) {
            throw new LottoBonusNumberRangeException(LOTTO_BONUS_NUMBER_MIN, LOTTO_BONUS_NUMBER_MAX);
        }
    }

    public boolean equalNumber(Integer number) {
        return this.number == number;
    }
}
