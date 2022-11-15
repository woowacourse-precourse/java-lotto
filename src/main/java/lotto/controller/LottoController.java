package lotto.controller;

import static lotto.view.OutputView.printLottoPurchaseCount;
import static lotto.view.OutputView.printTotalLottos;

import lotto.domain.lotto.TotalLottos;
import lotto.domain.purchaseAmount.PurchaseAmount;
import lotto.domain.winningElements.WinningElements;

import java.util.List;

public class LottoController {
    public void run() {
        long purchaseAmount = PurchaseAmount.getPurchaseAmount();
        long lottoPurchaseCount = takeLottoPurchaseCount(purchaseAmount);
        TotalLottos totalLottos = takeTotalLottos(lottoPurchaseCount);

        List<Integer> winningNumbers = WinningElements.getWinningNumbers();
        int bonusNumber = WinningElements.getBonusNumber();
    }

    public static long takeLottoPurchaseCount(long purchaseAmount) {
        long lottoPurchaseCount = PurchaseAmount.getLottoPurchaseCount(purchaseAmount);
        printLottoPurchaseCount(lottoPurchaseCount);

        return lottoPurchaseCount;
    }

    public static TotalLottos takeTotalLottos(long lottoPurchaseCount) {
        TotalLottos totalLottos = new TotalLottos(lottoPurchaseCount);
        printTotalLottos(totalLottos);

        return totalLottos;
    }
}
