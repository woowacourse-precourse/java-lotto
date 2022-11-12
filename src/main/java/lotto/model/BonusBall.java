package lotto.model;

import static lotto.constant.BonusBallConstants.EMPTY_BONUSBALL_MSG;
import static lotto.constant.BonusBallConstants.INVALID_BONUSBALL_INPUT_MSG;
import static lotto.constant.LottoConstants.MAX_VALID_LOTTO_VALUE;
import static lotto.constant.LottoConstants.MIN_VALID_LOTTO_VALUE;

public class BonusBall {
    private int value;

    public static BonusBall from(String userInput) {
        return new BonusBall(userInput);
    }

    public int getValue() {
        return this.value;
    }

    private BonusBall(String userInput) {
        validate(userInput);
        this.value = Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        isBlank(userInput);
        isConsistsWithOnlyDigits(userInput);
        isIntegerRange(userInput);
        isInProperRange(userInput);
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

    private void isIntegerRange(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_BONUSBALL_INPUT_MSG);
        }
    }

    private void isInProperRange(String userInput) {
        int pieceToInt = Integer.parseInt(userInput);
        if (pieceToInt < MIN_VALID_LOTTO_VALUE || pieceToInt >MAX_VALID_LOTTO_VALUE ) {
            throw new IllegalArgumentException(INVALID_BONUSBALL_INPUT_MSG);
        }
    }
}
