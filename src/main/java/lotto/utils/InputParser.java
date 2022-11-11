package lotto.utils;

import lotto.constant.ErrorMessage;

public class InputParser {
    public static Integer parseToInteger(String singleLine) {
        try {
            return Integer.parseInt(singleLine.trim());
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}
