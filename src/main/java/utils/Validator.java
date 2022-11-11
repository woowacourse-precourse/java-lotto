package utils;

import model.ErrorMessage;

public class Validator {
    public void validateNumber(String input) {
        validateFirstDigit(input);
        validateOtherDigit(input);
    }

    private void validateOtherDigit(String input) {
        for (int index = 1; index < input.length(); index++) {
            if (!Character.isDigit(getDigit(input, index))) {
                throw new IllegalArgumentException(ErrorMessage.INCORRECT_PURCHASING_AMOUNT.toString());
            }
        }
    }

    private void validateFirstDigit(String input) {
        char first = getDigit(input, 0);
        if (first == '0' || !Character.isDigit(first)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private char getDigit(String input, int index) {
        return input.charAt(index);
    }

}
