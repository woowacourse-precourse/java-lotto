package lotto.service;

import lotto.exception.InputException;

public class InputService {
    public int inputMoneyToInteger(String inputMoney) {
        moneyException(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public boolean moneyException(String inputMoney) {
        InputException inputException = new InputException();
        if (inputException.notDigitException(inputMoney)) {
            return true;
        }
        return false;
    }
}
