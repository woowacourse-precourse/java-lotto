package user;

import constants.LottoConstants;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseAmount / LottoConstants.MONEY_UNIT;
    }
}
