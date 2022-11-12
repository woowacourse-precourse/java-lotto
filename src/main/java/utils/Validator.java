package utils;

import model.LottoStatus;

import static model.ErrorMessage.*;

public class Validator {

    public void validateSize(String input) {
        if (input.length() < LottoStatus.PRICE.getDigitsSize()) {
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

    public void validateLuckyNumberSize(String input) {
        String[] numbers = getNumbers(input);
        if (numbers.length != LottoStatus.SIZE.getValue()) {
            throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_SIZE.toString());
        }

        for (String number : numbers) {
            if (number.length() > LottoStatus.END.getDigitsSize()) {
                throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_SIZE.toString());
            }
        }
    }

    private String[] getNumbers(String input) {
        return input.split(",");
    }

    public void validateLuckyNumberDigit(String input) {
        for (String number : getNumbers(input)) {
            checkNumber(number);
        }
    }

    private void checkNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (!Character.isDigit(getDigit(number, index))) {
                throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_DIGIT.toString());
            }
        }
    }
}
