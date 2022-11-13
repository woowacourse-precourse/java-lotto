package lotto.view;

import java.util.Arrays;
import lotto.exception.view.InputNotContainRestException;
import lotto.exception.view.InputNotNumberException;
import lotto.exception.view.InputPurchaseMoneyException;

public class InputViewValidator {
    private static final int ZERO = 0;
    private static final int INPUT_MONEY_UNIT = 1000;
    private static final String REST = ",";

    public void validateDivideThousand(int money) {
        if (money == ZERO || money % INPUT_MONEY_UNIT != ZERO) {
            throw new InputPurchaseMoneyException();
        }
    }

    public void validateContainRest(String text) {
        if (!text.contains(REST)) {
            throw new InputNotContainRestException();
        }
    }

    public void validateSplitByRestNumber(String text) {
        Arrays.stream(text.split(REST))
                .map(String::trim)
                .forEach(this::validateNumber);
    }

    public void validateNumber(String text) {
        if (text.length() != text.chars().filter(Character::isDigit).count()) {
            throw new InputNotNumberException();
        }
    }
}
