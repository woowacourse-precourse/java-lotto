package lotto.domain;

import static lotto.domain.Error.*;
import static lotto.domain.Number.*;

public class BonusNumber {
    private int bonusNumber;

    public void inputBonusNumber(String input) {
        validateNumbers(input);
        bonusNumber = toInt(input);
        validateRange(bonusNumber);
    }

    private void validateNumbers(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMBER.getMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER.getNumber() || bonusNumber > MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
