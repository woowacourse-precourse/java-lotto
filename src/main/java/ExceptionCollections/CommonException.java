package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class CommonException {
    static final String NUMBER = "^[0-9]*$";

    public static void hasCharacters(String number) {
        if (!number.matches(NUMBER)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
    }

    public static int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}
