package lotto.domain.purchaseAmount;

import lotto.view.InputView;

public class PurchaseAmount {

    public static long getPurchaseAmount() {
        String receivedPurchaseAmount = InputView.receivePurchaseAmount();

        PurchaseAmountValidator.validate(receivedPurchaseAmount);

        long purchaseAmount = Long.parseLong(receivedPurchaseAmount);
        return purchaseAmount;
    }
}
