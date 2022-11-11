package utils;

import model.LottoStatus;

import static model.ErrorMessage.INCORRECT_PURCHASING_AMOUNT;

public class Validator {

    public void validateSize(String input) {
        if (input.length() < LottoStatus.SIZE.getMinimumDigits()) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    public void validateNumber(String input) {
        validateFirstDigit(input);
        validateOtherDigit(input);
    }

    private void validateOtherDigit(String input) {
        for (int index = 1; index < input.length(); index++) {
            if (!Character.isDigit(getDigit(input, index))) {
                throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
            }
        }
    }

    private void validateFirstDigit(String input) {
        char first = getDigit(input, 0);
        if (first == '0' || !Character.isDigit(first)) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private char getDigit(String input, int index) {
        return input.charAt(index);
    }

    public void validateMonetaryUnit(String input) {
        if (!isMonetaryUnit(input)) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private boolean isMonetaryUnit(String input) {
        return Integer.parseInt(input) % LottoStatus.PRICE.getValue() == 0;
    }

}
