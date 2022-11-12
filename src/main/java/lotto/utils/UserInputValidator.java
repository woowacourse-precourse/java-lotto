package lotto.utils;

import static lotto.utils.Constants.*;

public class UserInputValidator {
    public static void validatePurchaseAmount(String purchaseAmount) {
        isDigit(purchaseAmount);
        isValidUnitOfMoney(Integer.parseInt(purchaseAmount));
    }

    private static void isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT_PURCHASE_AMOUNT);
        }
    }

    private static void isValidUnitOfMoney(int purchaseAmount) {
        if (purchaseAmount % UNIT_OF_MONEY != 0 || purchaseAmount == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY);
        }
    }
}
