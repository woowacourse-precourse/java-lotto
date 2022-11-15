package lotto.util;

public class Validator {
    public static <T> void validateNotNull(T object) {
        if (object == null) {
            ErrorHandler.throwException(ErrorMessage.NULL);
        }
    }

    public static void validateNotEmpty(String string) {
        if (string.equals("")) {
            ErrorHandler.throwException(ErrorMessage.EMPTY);
        }
    }

    public static <T> void validateInteger(T input) {
        try {
            Integer.parseInt((String) input);
        } catch (NumberFormatException e) {
            ErrorHandler.throwException(ErrorMessage.NOT_INTEGER_TYPE);
        }
    }
}
