package lotto.controller;

import static lotto.view.InputView.inputPaymentAmount;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        lottoService.purchaseLotto(inputPaymentAmount());
    }
}
