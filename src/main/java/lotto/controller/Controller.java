package lotto.controller;

import lotto.Env;
import lotto.util.Lang;
import lotto.util.Validator;

public abstract class Controller {
    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Lang.THROW_NON_NUMERIC_CHARACTER);
        }
    }

    public void validateNegativeNumber(int money) {
        if (Validator.isNegativeNumber(money)) {
            throw new IllegalArgumentException(Lang.THROW_NUMBER_NEGATIVE);
        }
    }

    public void validateLeftMoneyAfterBuyLotto(int money) {
        if (Validator.hasLeftMoneyAfterBuyLotto(money)) {
            throw new IllegalArgumentException(Lang.format(Lang.THROW_MONEY_LEFT_AFTER_BUY_LOTTO, Env.LOTTO_PRICE));
        }
    }
}
