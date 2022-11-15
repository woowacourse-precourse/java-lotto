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

    public static void exceptionNoNumbers(String input) {
        String[] winNumber = input.split(",");
        for (int i = 0; i < winNumber.length; i++) {
            exceptionNoNumber(winNumber[i]);
        }
    }

    public static void exceptionNoNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(Error.WRONG_LOTTO_NUM.getMsg());
            }
        }
    }

    public static void exceptionSize(String input) {
        String[] winNumber = input.split(",");
        if (winNumber.length != 6) {
            throw new IllegalArgumentException(Error.WRONG_LOTTO_LENGTH.getMsg());

        }
    }

}