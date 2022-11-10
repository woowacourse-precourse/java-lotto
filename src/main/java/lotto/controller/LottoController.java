package lotto.controller;

import lotto.dto.PurchaseAmountDto;
import lotto.view.InputView;

public class LottoController {
    private static final InputView inputView = InputView.INSTANCE;

    public void run() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        System.out.println(purchaseAmountDto);
    }
}
