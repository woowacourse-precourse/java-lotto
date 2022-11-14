package controller;

import service.MoneyService;
import view.InputView;

public class LottoController {
    private final MoneyService moneyService;

    public LottoController() {
        this.moneyService = new MoneyService();
    }

    private void getPurchaseAmount() {
        String purchaseAmount = InputView.receivePurchaseAmount();
        moneyService.savePurchaseAmount(purchaseAmount);
    }
}
