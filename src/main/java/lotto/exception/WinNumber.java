package lotto.exception;

import lotto.constants.Error;
import lotto.constants.Number;

public class WinNumber {
    public static void exceptionRange(String input) {
        String[] winNumber = input.split(",");
        int rangeStart = Number.RANGE_START.getNumber();
        int rangeEnd = Number.RANGE_END.getNumber();
        for (int i = 0; i < winNumber.length; i++) {
            if (!(rangeStart <= Integer.parseInt(winNumber[i]) && Integer.parseInt(winNumber[i]) <= rangeEnd)) {
                throw new IllegalArgumentException(Error.WRONG_LOTTO_RANGE.getMsg());
            }
        }
    }


}