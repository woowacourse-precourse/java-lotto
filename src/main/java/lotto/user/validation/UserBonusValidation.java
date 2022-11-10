package lotto.user.validation;

public class UserBonusValidation {
    private static final String NUMBER_REGEXP = "^[0-9]+$";
    public static void validate(String userInput) {
        validateOnlyNumber(userInput);
    }

    private static void validateOnlyNumber(String userInput) {
        if (!userInput.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER.toString());
        }
    }
}
