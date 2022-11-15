package lotto.domain;

public class BonusNumber {
    private int bonusNumber;

    public void inputBonusNumber(String input) {
        validateNumbers(input);
        bonusNumber = toInt(input);
        validateRange(bonusNumber);
    }

    private void validateNumbers(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Error.NUMBER.getMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Error.RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
