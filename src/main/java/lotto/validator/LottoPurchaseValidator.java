package lotto.validator;

import static lotto.constant.Constants.UNIT_OF_LOTTO_PURCHASE;

import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;
import lotto.constant.RegularExpression;

public class LottoPurchaseValidator {

    public static void validateInputMoneyIsNumeric(String userInput) {
        if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), userInput)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ALLOWED_ONLY_NUMERIC.getMessage());
        }
    }

    public static void validatePurchaseUnit(int money) {
        if (money % UNIT_OF_LOTTO_PURCHASE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE.getMessage()
            );
        }
    }
}
