package utils;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern REGEX = Pattern.compile("[0-9]+");

    public static void checkLottoPurchaseAmountIsValid(String userInput) {
        if (!userInput.matches(REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_INPUT_ABOUT_PURCHASE_MESSAGE);
        }

        int purchaseAmount = Integer.parseInt(userInput);
        if (purchaseAmount <= 0 ||
                purchaseAmount % LottoConstants.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(UIConstants.INVALID_INPUT_ABOUT_PURCHASE_MESSAGE);
        }
    }
}
