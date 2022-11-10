package lotto.model;

import lotto.constants.ErrorMessage;

public class Money {

    private int value;

    public Money(String input) {
        int inputNumber = stringToInt(input);
        validateBill(inputNumber);
        this.value = inputNumber;
    }

    private int stringToInt(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
        return inputNumber;
    }

    private void validateBill(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BILL);
        }
    }
}
