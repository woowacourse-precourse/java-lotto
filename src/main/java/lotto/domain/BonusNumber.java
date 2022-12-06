package lotto.domain;

import java.util.List;

import static lotto.util.message.ExceptionMessage.DUPLICATED;
import static lotto.util.message.ExceptionMessage.OUT_OF_SCOPE;
import static lotto.util.NumericProperties.MAX_NUM;
import static lotto.util.NumericProperties.MIN_NUM;

public class BonusNumber {
    private static int bonusNumber;

    public static void validate(int tmpBonusNumber, Lotto winningLotto) {
        bonusNumber = tmpBonusNumber;
        if (bonusNumber < MIN_NUM.get() || bonusNumber > MAX_NUM.get()) {
            throw new IllegalArgumentException(OUT_OF_SCOPE.get());
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED.get());
        }
    }

    public static boolean isIn(List<Integer> myLotto) {
        return myLotto.contains(bonusNumber);
    }
}
