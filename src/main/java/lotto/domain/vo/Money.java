package lotto.domain.vo;

import static lotto.domain.constants.ErrorCode.NOT_NEGATIVE_NUMBER;

public class Money {

    private final int value;

    public Money(int value) {
        validateMoney(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateMoney(int input) {
        if (input < 0) {
            throw NOT_NEGATIVE_NUMBER.getException();
        }
    }
}
