package controller;

import view.ErrorMessage;

public class Util {

    public static void validateInteger(String inputValue) {
        String pattern = "[0-9]+";
        if (!inputValue.matches(pattern))
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getErrorMessage());
    }

    public static void validateComma(String lottoWinningNumbers) {
        if (!lottoWinningNumbers.contains(","))
            throw new IllegalArgumentException(ErrorMessage.NOT_COMMA.getErrorMessage());
    }
}
