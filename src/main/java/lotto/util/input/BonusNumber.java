package lotto.util.input;

import java.util.regex.Pattern;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber) {
        validateOnlyNumber(bonusNumber);
        validateLength(bonusNumber);
    }
    private void validateOnlyNumber(String bonusNumber) {
        final String REGEX = "^[0-9]*[1-9]+$";
        if (!Pattern.matches(REGEX, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
    private void validateLength(String bonusNumber) {
        if (!(bonusNumber.length() > 0 || bonusNumber.length() < 3)) {
            throw new IllegalArgumentException();
        }
    }
}
