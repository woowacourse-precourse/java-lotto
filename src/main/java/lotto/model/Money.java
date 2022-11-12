package lotto.model;

import lotto.constants.ErrorCode;
import lotto.constants.LottoConstants;

public class Money {

    private int value;

    public Money(int value) {
        validateBill(value);
        this.value = value;
    }

    public int getMoney() {
        return value;
    }

    private void validateBill(int input) {
        if (input % LottoConstants.LOTTO_PRICE != 0) {
            throw ErrorCode.NOT_BILL.getException();
        }
    }
}
