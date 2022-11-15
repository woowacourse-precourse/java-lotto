package lotto.controller;

import lotto.domain.purchaseAmount.PurchaseAmount;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
        long lottoPurchaseCount = calculateLottoPurchaseCount(purchaseAmount);
    }

    public static long calculateLottoPurchaseCount(long purchaseAmount) {
        long lottoPurchaseCount = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);

        return lottoPurchaseCount;
    }
}
