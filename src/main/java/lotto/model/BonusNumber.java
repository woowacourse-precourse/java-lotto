package lotto.model;

import lotto.util.SystemErrorMessage;

import java.util.regex.Pattern;

public class BonusNumber {
    private int bonusNumber;
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber) {
        validateOnlyNumber(bonusNumber);
        validateNumberInRange(bonusNumber);
    }

    private void validateOnlyNumber(String bonusNumber) {
        final String REGEX = "^[0-9]*$";
        if (!Pattern.matches(REGEX, bonusNumber)) {
            throw new IllegalArgumentException(SystemErrorMessage.NUMBER_ERROR.getErrorMessage());
        }
    }

    private void validateNumberInRange(String winNumber) {
        int number = Integer.parseInt(winNumber);
        if (!(number >= MIN_VALUE && number <= MAX_VALUE)) {
            throw new IllegalArgumentException(SystemErrorMessage.NUMBER_ERROR.getErrorMessage());
        }
    }
}
