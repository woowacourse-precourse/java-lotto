package lotto.exception;

import java.util.regex.Pattern;

public class InputException {
    private static final String ERROR_FORM = "[ERROR] ";
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String NOT_SPLIT = "1000원으로 나누어 떨어지지 않습니다.";
    private static final String UNDER = "1000원 미만입니다.";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private InputException() {}

    public static void validatesLottoAmount(String amount) {
        validateNumber(amount);
        validateSplit(amount);
        validateUnder(amount);
    }

    private static void validateNumber(String number) {
        if(!Pattern.matches(NUMBER_REGEX, number)) {
            exception(NOT_NUMBER);
        }
    }

    private static void validateSplit(String number) {
        if(Integer.parseInt(number) % 1000 != 0) {
            exception(NOT_SPLIT);
        }
    }

    private static void validateUnder(String number) {
        if(Integer.parseInt(number) < 1000) {
            exception(UNDER);
        }
    }

    private static void exception(String message) {
        throw new IllegalArgumentException(ERROR_FORM + message);
    }
}
