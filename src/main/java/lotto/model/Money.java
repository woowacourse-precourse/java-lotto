package lotto.model;

import lotto.constants.ErrorCode;

public class Money {

    private int value;

    public Money(int value) {
        validateBill(value);
        this.value = value;
    }

    private void validateBill(int input) {
        if (input % 1000 != 0) {
            throw ErrorCode.NOT_BILL.getException();
        }
    }
}
