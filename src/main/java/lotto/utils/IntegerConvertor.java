package lotto.utils;

public class IntegerConvertor {
    public static int toInteger(String input, String message) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
