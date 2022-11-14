package lotto.controller;

import lotto.domain.LottoQuantityCalculation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        int purchaseQuantity = lottoPurchaseQuantity(InputView.inputLottoPurchaseAmount());
    }

    private int lottoPurchaseQuantity(int purchaseAmount) {
        LottoQuantityCalculation lottoQuantityCalculation = new LottoQuantityCalculation(purchaseAmount);
        int purchaseQuantity = lottoQuantityCalculation.purchaseQuantity();
        OutputView.OutputLottoPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }
}
