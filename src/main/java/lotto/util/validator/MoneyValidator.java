package lotto.util.validator;

import lotto.util.Constants;
import lotto.util.Utils;

public class MoneyValidator {
    private String money;

    public MoneyValidator(String money) {
        this.money = money;
        isInt();
        isThousand();
        isPositive();
    }

    private void isInt() {
        try {
            Utils.convertToInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_NUMBER);
        }
    }

    private void isThousand() {
        if ((Utils.convertToInt(money) % 1000) != 0) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_THOUSAND);
        }
    }

    private void isPositive() {
        if (!(Utils.convertToInt(money) > 0)) {
            throw new IllegalArgumentException(Constants.ERROR_MONEY_POSITIVE);
        }
    }
}
