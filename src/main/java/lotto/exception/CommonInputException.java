package lotto.exception;

public class CommonInputException {

    private static final String NO_INPUT_ERROR_MESSAGE = "[ERROR] 입력값이 없습니다.";
    private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력에 공백이 있습니다.";

    private CommonInputException() {
    }

    public static void checkCommonInput(String input) {
        checkEmptyInput(input);
        checkHasBlankInInput(input);
    }

    public static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_ERROR_MESSAGE);
        }
    }

    public static void checkHasBlankInInput(String input) {
        if (!input.equals(input.trim())) {
            throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
        }
    }
}
