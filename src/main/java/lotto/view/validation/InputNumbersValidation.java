package lotto.view.validation;

public class InputNumbersValidation {
    private static final String INPUT_NUMBERS_REGEXP = "^([1-9]+,)+[1-9]+$";

    public static void validate(String userInput) {
        validateInputFormat(userInput);
    }

    private static void validateInputFormat(String uerInput) {
        if (!uerInput.matches(INPUT_NUMBERS_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_FORMAT.toString());
        }
    }
}
