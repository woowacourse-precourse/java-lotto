package lotto.util;

import java.util.regex.Pattern;
import lotto.util.constants.GameConstants;
import lotto.util.constants.LottoConstants;

public class InputValidator {

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

    public boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public boolean isPositiveNumber(String number) {
        return Integer.parseInt(number) > 0;
    }

    public boolean isDivisibleBy1000(String number) {
        return Integer.parseInt(number) % LottoConstants.LOTTO_TICKET_PRICE == 0;
    }

    public void validateWinningNumber(String winningNumber) {
        if (!isNumberOrComma(winningNumber)) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_NUMBER_OR_COMMA);
        }
    }

    public boolean isNumberOrComma(String winningNumber) {
        String pattern = "^[0-9,]*$";
        return Pattern.matches(pattern, winningNumber);
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_NUMBER_BONUS);
        }
    }
}
