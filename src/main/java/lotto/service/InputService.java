package lotto.service;

import lotto.domain.User;
import lotto.exception.InputException;

public class InputService {
    User user;

    public int inputMoneyToInteger(String inputMoney) {
        InputException inputException = new InputException();
        inputException.notDigitException(inputMoney);
        inputException.notThousandMoneys(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }

    public void setMoneyToUser(String inputMoney) {
        user = new User(inputMoneyToInteger(inputMoney));
    }

    public User getUser() {
        return user;
    }
}
