package lotto.util;

import java.util.List;

public class Validate {
    public static final String ERROR_IS_NULL = "[ERROR] NULL 값은 허용하지 않습니다.";
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 숫자이외의 값이 포함되어 있습니다.";

    public static void isNull(Object number) {
        if (number == null) {
            throw new IllegalArgumentException(ERROR_IS_NULL);
        }
    }

    public static void isNumber(String number) {
        if (!number.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }

    public static void isNumbers(List<String> numbers) {
        numbers.stream().forEach(e -> isNumber(e));
    }
}