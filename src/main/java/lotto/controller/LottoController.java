package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void startProgram() {
        lottoService.initLotto();
    }
}
