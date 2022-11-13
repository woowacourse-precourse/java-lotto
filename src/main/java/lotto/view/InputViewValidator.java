package lotto.view;

import lotto.exception.view.InputNotNumberException;
import lotto.exception.view.InputPurchaseMoneyException;

public class InputViewValidator {
    private static final int ZERO = 0;
    private static final int INPUT_MONEY_UNIT = 1000;

    public void validateDivideThousand(int money) {
        if (money == ZERO || money % INPUT_MONEY_UNIT != ZERO) {
            throw new InputPurchaseMoneyException();
        }
    }

    public void validateNumber(String text) {
        if (text.length() != text.chars().filter(Character::isDigit).count()) {
            throw new InputNotNumberException();
        }
    }
}
