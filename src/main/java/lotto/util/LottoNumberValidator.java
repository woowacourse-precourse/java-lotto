package lotto.util;

import lotto.domain.errorenum.Error;
import lotto.domain.lottoenum.LottoCondition;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateInRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getCode());
        }
    }

    public static boolean isCorrectLength(int size) {
        return size == LottoCondition.LENGTH.getValue();
    }

    private static boolean isInRange(int number) {
        return number >= LottoCondition.MIN.getValue() && number <= LottoCondition.MAX.getValue();
    }

}
