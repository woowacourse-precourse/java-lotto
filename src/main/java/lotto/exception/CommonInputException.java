package lotto.exception;

public class CommonInputException {

    public static void checkCommonInput(String input, String message) {
        checkEmptyInput(input, message);
        checkHasBlankInInput(input, message);
    }

    public static void checkEmptyInput(String input, String message) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]" + message + " 입력해주세요.");
        }
    }

    public static void checkHasBlankInInput(String input, String message) {
        if (!input.equals(input.trim())) {
            throw new IllegalArgumentException("[ERROR]" + message + " 공백없이 입력해주세요.");
        }
    }
}
