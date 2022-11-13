package lotto.utils;

public class Validation {

    public static void validateIsNumber(String target) throws IllegalArgumentException {
        String numberRegex = "^[0-9]*$";
        if (!target.matches(numberRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }
}
