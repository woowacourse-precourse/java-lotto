package controller;

import service.LottoService;
import service.MoneyService;
import view.InputView;

public class LottoController {
    private final MoneyService moneyService;
    private final LottoService lottoService;

    public LottoController() {
        this.moneyService = new MoneyService();
        this.lottoService = new LottoService();
    }

    private void getPurchaseAmount() {
        String purchaseAmount = InputView.receivePurchaseAmount();
        moneyService.savePurchaseAmount(purchaseAmount);
    }

    private void publishLotto() {
        int purchaseAmount = moneyService.getPurchaseAmount();
        lottoService.publishLotto(purchaseAmount);
    }
    
}
