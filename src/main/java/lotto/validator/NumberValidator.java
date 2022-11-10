package lotto.validator;

public class NumberValidator {
    private final static int UNIT = 1000;
    private final static String RANGE_ERROR_MESSAGE = "[ERROR] 1000으로 나누어 떨어지는 숫자여야 합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";

    public static void validateUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateNonNumeric(String input) {
        for (char charString : input.toCharArray()) {
            if (charString >= 48 && charString <= 57) {
                continue;
            }
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
