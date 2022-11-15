package lotto.domain.purchaseAmount;

import lotto.view.InputView;

public class PurchaseAmount {
    static final int LOTTO_PRICE = 1000;

    public static long getPurchaseAmount() {
        String receivedPurchaseAmount = InputView.receivePurchaseAmount();

        PurchaseAmountValidator.validate(receivedPurchaseAmount);

        long purchaseAmount = Long.parseLong(receivedPurchaseAmount);
        return purchaseAmount;
    }

    public static long getLottoPurchaseCount(long purchaseAmount) {
        long lottoCount = purchaseAmount / LOTTO_PRICE;

        return lottoCount;
    }
}
