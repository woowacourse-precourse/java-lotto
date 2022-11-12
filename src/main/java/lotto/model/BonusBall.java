package lotto.model;

import static lotto.constant.BonusBallConstants.EMPTY_BONUSBALL_MSG;
import static lotto.constant.BonusBallConstants.INVALID_BONUSBALL_INPUT_MSG;

public class BonusBall {
    private int value;

    public static BonusBall from(String userInput) {
        return new BonusBall(userInput);
    }

    private BonusBall(String userInput) {
        validate(userInput);
        this.value = Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        isBlank(userInput);
        isConsistsWithOnlyDigits(userInput);
    }

    private void isBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(EMPTY_BONUSBALL_MSG);
        }
    }

    private void isConsistsWithOnlyDigits(String userInput) {
        for (char piece : userInput.toCharArray()) {
            isDigit(piece);
        }
    }

    private void isDigit(char piece) {
        if (!Character.isDigit(piece)) {
            throw new IllegalArgumentException(INVALID_BONUSBALL_INPUT_MSG);
        }
    }
}
