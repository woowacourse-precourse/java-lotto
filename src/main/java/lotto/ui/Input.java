package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;
import lotto.utils.ErrorMessage;

public class Input {
    private static final Integer REMAINDER = 0;

    public static Integer getPurchaseAmount() {
        return validatePurchaseAmount(toInts(Console.readLine()));
    }

    public static Integer validatePurchaseAmount(int amount) {
        if (!(amount % Constant.PURCHASE_AMOUNT_UNIT == REMAINDER)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR);
        }
        return amount;
    }

    private static Integer toInts(String number) {
        return Integer.parseInt(number);
    }
}
