package lotto.util;

public class PurchaseAmountValidator {

    public boolean isNumber(String purchaseAmount) {
        return purchaseAmount.chars().allMatch(Character::isDigit);
    }

    public boolean isPositiveNumber(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) > 0;
    }

    public boolean isDivisibleBy1000(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % 1000 != 0;
    }

}
