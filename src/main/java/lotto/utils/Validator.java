package lotto.utils;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern ONE_NUMBER = Pattern.compile("^([0-9])+");
    private static final Pattern LOTT_NUMBER = Pattern.compile("^(,?[0-9])+");
    private static final String WRONG_FORMAT = "[ERROR] 형식이 올바르지 않습니다.";

    public static void isOneNumber(String number) {
        if (!ONE_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException(WRONG_FORMAT);
        }
    }

    public static void isNumbers(String inputNumbers) {
        if (!LOTT_NUMBER.matcher(inputNumbers).matches()) {
            throw new IllegalArgumentException(WRONG_FORMAT);
        }
    }
}
