package lotto.util;

public class PurchaseAmountValidator {

    public boolean isNumber(String purchaseAmount) {
        return purchaseAmount.chars().allMatch(Character::isDigit);
    }

}
