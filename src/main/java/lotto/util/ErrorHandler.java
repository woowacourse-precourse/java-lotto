package lotto.util;

public class ErrorHandler {
    public static void throwException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.text());
    }
}
