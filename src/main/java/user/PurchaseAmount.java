package user;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.regex.Pattern;

public class PurchaseAmount {

    private static final Pattern REGEX = Pattern.compile("[0-9]+");
    private final int purchaseAmount;

    public PurchaseAmount(String userInput) {
        checkValidateInput(userInput);
        purchaseAmount = Integer.parseInt(userInput);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void checkValidateInput(String userInput) {
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
