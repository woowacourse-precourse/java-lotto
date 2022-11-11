package lotto.validate;

import lotto.error.ErrorType;

public class NumberValidator {

    public void validateBuyMoney(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorType.NOT_DIVIDE.showMessage());
        }

        if (Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException();
        }
    }

}
