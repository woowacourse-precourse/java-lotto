package lotto.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_FORMAT = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    private static final String INPUT_NUMBER_FORMAT = "[ERROR] 숫자 형식을 입력해주세요.";
    public static final String INPUT_RIGHT_FORMAT = "[ERROR] 콤마(,)로 구분되는 숫자 6개를 입력해 주세요.";
    private ValidationUtils() {
    }

    public static void validateWinningNumber(String number) {
        if (isWinningNumberFormat(number)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_RIGHT_FORMAT);
    }

    private static boolean isWinningNumberFormat(String number) {
        return Pattern.matches(WINNING_NUMBER_FORMAT, number);
    }

    public static void validateBonusNumber(String number) {
        validateNumber(number);
    }

    public static void validateNumber(String number) {
        if (Pattern.matches(NUMBER_REGEX, number)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_NUMBER_FORMAT);
    }
}
