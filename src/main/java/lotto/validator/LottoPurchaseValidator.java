package lotto.validator;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;

public class LottoPurchaseValidator {

    public static void validatePurchaseUnit(int money) {
        if (money % UNIT_OF_LOTTO_PURCHASE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
