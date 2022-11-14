package lotto.util;


public class ValidUtil {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validInputAmounts(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE +" 숫자를 입력해야 합니다.");
        }
    }

}
