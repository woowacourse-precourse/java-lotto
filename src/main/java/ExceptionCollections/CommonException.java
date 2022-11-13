package ExceptionCollections;

import enumCollections.Exceptions;

public class CommonException {
    public static final String regularExpression = "^[0-9]*$";

    public static void hasCharacters(String numbers) {
        if (!numbers.matches(regularExpression)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
    }


}
