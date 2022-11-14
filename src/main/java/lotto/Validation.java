package lotto;

public class Validation {

    void validatePurchase(String input) {
        validateIsMoney(input);
        validateUnit(input);
        validateIsZero(input);
    }

    void validateIsMoney(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_NUMBER_ERROR.getMessage());
            }
        }
    }

    void validateUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NUMBER_ERROR.getMessage());
        }
    }

    void validateIsZero(String input) {
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_ZERO_ERROR.getMessage());
        }
    }

    void validateIsNumber(String input) {
        for (char c : String.join("", input).toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR.getMessage());
            }
        }
    }
}
