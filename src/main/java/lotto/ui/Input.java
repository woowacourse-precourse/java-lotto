package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;

public class Input {
    private static final Integer REMAINDER = 0;

    public static Integer getPurchaseAmount() {
        return validatePurchaseAmount(toInts(Console.readLine()));
    }

    public static Integer validatePurchaseAmount(int amount) {
        if (!(amount % Constant.PURCHASE_AMOUNT_UNIT == REMAINDER)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return amount;
    }

    private static Integer toInts(String number) {
        return Integer.parseInt(number);
    }
}
