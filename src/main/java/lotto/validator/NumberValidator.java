package lotto.validator;

public class NumberValidator {
    private final static int MIN_RANGE_NUM = 1000;
    private final static int UNIT = 1000;
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;
    private final static String INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 1000으로 나누어 떨어지는 숫자여야 합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";
    private final static String AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 1000이상 숫자를 입력해주세요.";
    private final static String OUT_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateUnit(int input) {
        if (input % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE);
        }
    }

    public static void validateAmountRange(int input) {
        if (input < MIN_RANGE_NUM) {
            throw new IllegalArgumentException(AMOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
        }
    }
}
