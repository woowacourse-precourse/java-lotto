package lotto.util;

import lotto.exception.InvalidNumberException;

public class IntConverter {
    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }
}
