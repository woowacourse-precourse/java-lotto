package lotto.domain.vo;

import lotto.domain.constants.ErrorCode;
import lotto.domain.constants.LottoConstants;

public class Money {

    private final int value;

    public Money(int value) {
        validateMoney(value);
        this.value = value;
    }

    public int getMoney() {
        return value;
    }

    private void validateMoney(int input) {
        if (input < 0) {
            throw ErrorCode.NOT_NEGATIVE_NUMBER.getException();
        }
    }
}
