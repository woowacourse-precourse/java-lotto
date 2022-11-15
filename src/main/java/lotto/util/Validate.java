package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static final String ERROR_IS_NULL = "[ERROR] NULL 값은 허용하지 않습니다.";
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 숫자이외의 값이 포함되어 있습니다.";
    public static final String ERROR_DUPLICATE_VALUE = "[ERROR] 중복 값이 포함되어 있습니다.";

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

    public static void duplication(List<Integer> numbers) {
        Set<Integer> sameNumber = new HashSet<>(numbers);
        if (numbers.size() != sameNumber.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_VALUE);
        }
    }
}