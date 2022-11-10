package lotto;

public class ValidationUtil {

    private static void isValidInput(String str) {
        if (!str.matches("[0-9]|,")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }
}
