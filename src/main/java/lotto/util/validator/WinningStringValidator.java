package lotto.util.validator;

import lotto.util.Constants;
import lotto.util.Utils;

public class WinningStringValidator {
    private String winningString;
    private String bonusString;

    public WinningStringValidator(String winningString, String bonusString) {
        this.winningString = winningString;
        this.bonusString = bonusString;
        isLengthZero();
        isIntOrComma();
        isCorrectComma();
        isIntBonus();
        isBonusDuplicated();
        isBonusCorrectRange();
    }

    private void isLengthZero() {
        try {
            winningString.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_LENGTH_ZERO);
        }
    }

    private void isIntOrComma() {
        for (int index = 0; index < winningString.length(); index++) {
            if (winningString.charAt(index) == ',') {
                continue;
            }
            if ((winningString.charAt(index) >= '0') && (winningString.charAt(index) <= '9')) {
                continue;
            }
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_STRING);
        }
    }

    private void isCorrectComma() {
        if (winningString.charAt(0) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
        if (winningString.charAt(winningString.length() - 1) == ',') {
            throw new IllegalArgumentException(Constants.ERROR_WINNING_NUMBER_COMMA);
        }
    }

    private void isIntBonus() {
        try {
            Utils.convertToInt(bonusString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_INT);
        }
    }

    private void isBonusDuplicated() {
        if (Utils.isContain(bonusString, Utils.convertToList(winningString))) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    private void isBonusCorrectRange() {
        int check = Utils.convertToInt(bonusString);

        if ((check > 45) || (check < 1)) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_Range);
        }
    }
}
