package lotto.domain.exceptions;

import lotto.data.ErrorMessage;
import lotto.domain.StartLotto;

public class BonusInputException {

    public static void bonusTypeError(String inputBonusNum) {
        for (int i = 0; i < inputBonusNum.length(); i++)
            if (!Character.isDigit(inputBonusNum.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getErrorLog());
    }

    public static void bonusRangeError() {
        if (StartLotto.bonusNum < 0 || StartLotto.bonusNum > 45)
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorLog());
    }

    public static void bonusDuplicate() {
        if (StartLotto.winNums.contains(StartLotto.bonusNum))
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorLog());
    }
}
