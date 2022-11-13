package lotto.controller;

import lotto.service.LottoService;
import lotto.views.InputView;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final InputView inputView = new InputView();

    public void startLottoApplication() {
        String inputPrice = inputView.inputPrice();
        lottoService.buyLottos(Integer.parseInt(inputPrice));
    }
}