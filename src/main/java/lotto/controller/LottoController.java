package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void executeGame() {
        lottoService.inputLottoPrice();

        lottoService.publishLottos();
        lottoService.showLottoResult();

        lottoService.inputWinningLottoNumbers();
        lottoService.inputBonusNumber();

        lottoService.calculateUserLottos();
    }
}
