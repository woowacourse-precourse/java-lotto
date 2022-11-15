package lotto.controller;

import static lotto.view.OutputView.printLottoPurchaseCount;

import lotto.domain.purchaseAmount.PurchaseAmount;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
        long lottoPurchaseCount = takeLottoPurchaseCount(purchaseAmount);
    }

    public static long takeLottoPurchaseCount(long purchaseAmount) {
        long lottoPurchaseCount = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);
        printLottoPurchaseCount(lottoPurchaseCount);

        return lottoPurchaseCount;
    }
}
