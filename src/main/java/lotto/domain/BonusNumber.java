package lotto.domain;

import java.util.Set;

public class BonusNumber {
    private int bonusNumber;

    public void inputBonusNumber(String input, Set<Integer> winningNumber) {
        validateNumbers(input);
        bonusNumber = toInt(input);
        validateRange(bonusNumber);
        validateUnique(bonusNumber, winningNumber);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateUnique(int bonusNumber, Set<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.IS_NOT_UNIQUE.getMessage());
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Error.IS_NOT_RANGE.getMessage());
        }
    }

    private void validateNumbers(String str) {
        if (str.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
    }
}
