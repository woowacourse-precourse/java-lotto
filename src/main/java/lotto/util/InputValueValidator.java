package lotto.util;

public class InputValueValidator {

    private boolean isNumber(String purchaseAmount) {
        return purchaseAmount.chars().allMatch(Character::isDigit);
    }

}
