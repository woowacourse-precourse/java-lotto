package lotto.model;

import lotto.constants.ErrorCode;

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
            throw ErrorCode.NOT_NUMBER.getException();
        }
        return inputNumber;
    }

    private void validateBill(int input) {
        if (input % 1000 != 0) {
            throw ErrorCode.NOT_BILL.getException();
        }
    }
}
