package user;

import constants.LottoConstants;
import constants.UIConstants;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(String userInput) {
        validate(userInput);
        this.purchaseAmount = Integer.parseInt(userInput);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validate(String userInput) {
        if (!userInput.matches(LottoConstants.REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_PURCHASE_AMOUNT);
        }

        int purchaseAmount = Integer.parseInt(userInput);
        if (purchaseAmount <= 0 ||
                purchaseAmount % LottoConstants.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(UIConstants.INVALID_PURCHASE_AMOUNT);
        }
    }

    public int getPurchaseCount() {
        return purchaseAmount / LottoConstants.MONEY_UNIT;
    }
}
