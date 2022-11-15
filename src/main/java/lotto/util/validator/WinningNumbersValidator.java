package lotto.util.validator;

import lotto.util.Constants;

public class WinningNumbersValidator {
    private String winningNumber;

    public WinningNumbersValidator(String winningNumber) {
        this.winningNumber = winningNumber;
        isLengthZero();
        isIntOrComma();
        isCorrectComma();
    }

    private void isLengthZero() {
        try {
            winningNumber.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_LENGTH_ZERO);
        }
    }

    private void isIntOrComma() {
        for (int index = 0; index < winningNumber.length(); index++) {
            if (winningNumber.charAt(index) == ',') {
                continue;
            }
            if ((winningNumber.charAt(index) >= '0') && (winningNumber.charAt(index) <= '9')) {
                continue;
            }
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_STRING);
        }
    }

    private void isCorrectComma() {
        if (winningNumber.charAt(0) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
        if (winningNumber.charAt(winningNumber.length() - 1) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
    }
}
