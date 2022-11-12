package lotto.validator;

import lotto.constant.ErrorMessage;

public class Validator {

    public void validateMoney(int money) {
        if (money < 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY);
        }
    }
}
