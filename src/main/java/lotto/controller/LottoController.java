package lotto.controller;

import static lotto.view.OutputView.printLottoPurchaseCount;

import lotto.domain.lotto.TotalLottos;
import lotto.domain.purchaseAmount.PurchaseAmount;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
        long lottoPurchaseCount = takeLottoPurchaseCount(purchaseAmount);
        TotalLottos totalLottos = takeTotalLottos(lottoPurchaseCount);
    }

    public static long takeLottoPurchaseCount(long purchaseAmount) {
        long lottoPurchaseCount = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);
        printLottoPurchaseCount(lottoPurchaseCount);

        return lottoPurchaseCount;
    }

    public static TotalLottos takeTotalLottos(long lottoPurchaseCount) {
        TotalLottos totalLottos = new TotalLottos(lottoPurchaseCount);

        return totalLottos;
    }
}
