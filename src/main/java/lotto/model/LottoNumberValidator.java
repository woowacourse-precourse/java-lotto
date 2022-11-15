package lotto.model;

import lotto.domain.LottoCondition;
import lotto.domain.LottoError;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateInRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(LottoError.NOT_IN_RANGE.printError());
        }
    }

    public static boolean isCorrectLength(int size) {
        return size == LottoCondition.LOTTO_RANGE_LENGTH.getNum();
    }

    private static boolean isInRange(int number) {
        return number >= LottoCondition.LOTTO_RANGE_MIN.getNum() && number <= LottoCondition.LOTTO_RANGE_MAX.getNum();
    }
}
