package lotto.ui;

import java.util.regex.Pattern;

public class InputViewValidation {

    static final String ERROR_NOT_INTEGER_FORMAT = "[ERROR] 숫자만 입력해주세요.";
    static final String ERROR_NOT_1000 = "[ERROR] 1000단위 숫자만 입력해주세요.";
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");


    public static void validateIsInteger(String input) {
        if (!NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_FORMAT);
        }
    }

    public static void validateIs1000(String input) {
        if (input.charAt(input.length() - 1) != '0' || input.charAt(input.length() - 2) != '0' || input.charAt(input.length() - 3) != '0') {
            throw new IllegalArgumentException(ERROR_NOT_1000);
        }
    }
}
