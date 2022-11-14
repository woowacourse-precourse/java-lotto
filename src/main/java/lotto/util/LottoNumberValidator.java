package lotto.util;

import lotto.domain.errorenum.LottoError;
import lotto.domain.lottoenum.LottoCondition;

// 로또 번호 검증 시 공통적으로 사용되는 검증 로직
public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateInRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(LottoError.NOT_IN_RANGE.printError());
        }
    }

    public static boolean isCorrectLength(int size) {
        return size == LottoCondition.LENGTH.getValue();
    }

    private static boolean isInRange(int number) {
        return number >= LottoCondition.MIN.getValue() && number <= LottoCondition.MAX.getValue();
    }

}
