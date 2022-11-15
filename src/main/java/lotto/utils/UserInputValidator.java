package lotto.utils;

import static lotto.utils.Constants.*;

public class UserInputValidator {
    public static void validatePurchaseAmount(String purchaseAmount) {
        isDigit(purchaseAmount);
        isValidUnitOfMoney(Integer.parseInt(purchaseAmount));
        isRangeOfPurchaseAmount(Long.parseLong(purchaseAmount));
    }

    private static void isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT_PURCHASE_AMOUNT);
        }
    }

    private static void isValidUnitOfMoney(int purchaseAmount) {
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0 || purchaseAmount == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY);
        }
    }

    private static void isRangeOfPurchaseAmount(long purchaseAmount) {
        if (purchaseAmount < LOTTO_TICKET_PRICE || purchaseAmount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_RANGE_OF_PURCHASE_AMOUNT);
        }
    }
}
