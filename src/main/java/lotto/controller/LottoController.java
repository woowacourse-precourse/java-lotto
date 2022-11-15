package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        lottoService.startLottoGame();
    }
}
