package lotto.util;

import lotto.GameConstants;

public class PurchaseAmountValidator {

    public void validatePurchaseAmount(String purchaseAmount) {
        if (!isNumber(purchaseAmount)) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_NUMBER);
        }

        if (!isPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_POSITIVE_NUMBER);
        }

        if (!isDivisibleBy1000(purchaseAmount)) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_DIVISIBLE_BY_1000);
        }
    }

    public boolean isNumber(String purchaseAmount) {
        return purchaseAmount.chars().allMatch(Character::isDigit);
    }

    public boolean isPositiveNumber(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) > 0;
    }

    public boolean isDivisibleBy1000(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % 1000 == 0;
    }

}
