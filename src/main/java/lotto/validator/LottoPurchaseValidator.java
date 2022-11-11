package lotto.validator;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;

import lotto.constant.ErrorMessage;

public class LottoPurchaseValidator {

    public static void validatePurchaseUnit(int money) {
        if (money % UNIT_OF_LOTTO_PURCHASE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE.getMessage()
            );
        }
    }
}
