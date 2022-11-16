package lotto.exception;

import lotto.constant.ErrorMessage;

public class IllegalLottoNumberAmountException extends IllegalArgumentException {
    public IllegalLottoNumberAmountException() {
        super(ErrorMessage.NOT_EQUAL_TO_LOTTO_NUMBER_AMOUNT.getMessage());
    }
}
