package lotto.util;

import java.util.List;

public class Validator {
    public Validator() {}

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



//    public static void validateIntegerInRange(int integer, int startInclusive, int endInclusive) {
//        if (integer < startInclusive
//                || integer > endInclusive) {
//            ErrorHandler.throwException(ErrorMessage.NOT_NULL);
//        }
//    }

    public static <T> void validateInteger(T input) {
        try {
            Integer.parseInt((String) input);
        } catch (NumberFormatException e) {
            ErrorHandler.throwException(ErrorMessage.NOT_INTEGER_TYPE);
        }
    }
}
