package lotto.util.validator;

import lotto.util.Constants;

public class WinningStringValidator {
    private String winningString;

    public WinningStringValidator(String winningString) {
        this.winningString = winningString;
        isLengthZero();
        isIntOrComma();
        isCorrectComma();
    }

    public void isLengthZero() {
        try {
            winningString.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_LEGNTH_ZERO);
        }
    }

    public void isIntOrComma() {
        for (int index = 0; index < winningString.length(); index++) {
            if (winningString.charAt(index) == ',') {
                continue;
            }
            if ((winningString.charAt(index) > '0') && (winningString.charAt(index) <= '9')) {
                continue;
            }
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_STRING);
        }
    }

    public void isCorrectComma() {
        if (winningString.charAt(0) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
        if (winningString.charAt(winningString.length() - 1) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
    }
}
