package lotto.domain.purchaseAmount;

import lotto.view.InputView;

public class PurchaseAmount {

    public static long getPurchaseAmount() {
        String receivedPurchaseAmount = InputView.receivePurchaseAmount();

        long purchaseAmount = Long.parseLong(receivedPurchaseAmount);
        return purchaseAmount;
    }
}
