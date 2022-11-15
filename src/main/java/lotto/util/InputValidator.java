package lotto.util;

import java.util.regex.Pattern;

public final class InputValidator {

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!isNumber(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }

        if (!isPositiveNumber(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER);
        }
    }

    public static void validateWinningNumber(String winningNumber) {
        if (!isNumberOrComma(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_AND_COMMA);
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_TO_BONUS);
        }
    }

    public static boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public static boolean isPositiveNumber(String number) {
        return Integer.parseInt(number) > 0;
    }

    public static boolean isNumberOrComma(String winningNumber) {
        String pattern = "^[0-9,]*$";
        return Pattern.matches(pattern, winningNumber);
    }

}
