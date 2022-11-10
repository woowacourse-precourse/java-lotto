package lotto.util.validator;

import lotto.util.Constants;
import lotto.util.Utils;

public class MoneyValidator {
    private String money;

    public MoneyValidator(String money) {
        this.money = money;
        isInteger();
        isThousand();
        isPositive();
    }

    public void isInteger() {
        try {
            Utils.stringToIntMoney(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_NUMBER);
        }
    }

    public void isThousand() {
        if ((Utils.stringToIntMoney(money) % 1000) != 0) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_THOUSAND);
        }
    }

    public void isPositive() {
        if (!(Utils.stringToIntMoney(money) > 0)) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_POSITIVE);
        }
    }
}
