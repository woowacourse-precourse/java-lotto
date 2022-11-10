package lotto.service;

import lotto.exception.InputException;

public class InputService {

    public int inputMoneyToInteger(String inputMoney) {
        InputException inputException = new InputException();
        inputException.notDigitException(inputMoney);
        inputException.notThousandMoneys(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }
}
