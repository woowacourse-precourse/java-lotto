package lotto.controller;

import lotto.dto.PurchaseAmountDto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private static final InputView inputView = InputView.INSTANCE;

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
    }
}
