package lotto.exception;

import java.util.List;
import lotto.constants.Error;
import lotto.constants.Number;

public class BonusNumber {
    public static void exceptionBonusNumber(String bonusNumber, List<Integer> winNumber) {
        exceptionNoNumber(bonusNumber);
        exceptionRange(bonusNumber);
        exceptionDuplication(bonusNumber, winNumber);
    }

    public static void exceptionRange(String bonusNumber) {
        int rangeStart = Number.RANGE_START.getNumber();
        int rangeEnd = Number.RANGE_END.getNumber();
        int check = Integer.parseInt(bonusNumber);
        if (!(rangeStart <= check && check <= rangeEnd)) {
            throw new IllegalArgumentException(Error.WRONG_BONUS_NUM_RANGE.getMsg());
        }
    }

    public static void exceptionNoNumber(String bonusNumber) {
        char check[] = bonusNumber.toCharArray();
        for (int i = 0; i < check.length; i++) {
            if (!Character.isDigit(check[i])) {
                throw new IllegalArgumentException(Error.WRONG_BONUS_NUM.getMsg());
            }
        }
    }

    public static void exceptionDuplication(String bonusNumber, List<Integer> winNumber) {
        if (winNumber.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(Error.DUPLICATE_BONUS_NUM.getMsg());
        }
    }
}
