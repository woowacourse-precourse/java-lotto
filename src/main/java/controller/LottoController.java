package controller;

import service.LottoService;

public class LottoController {
    private static LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void buy() {
        lottoService.init();
    }

    public void caculateResult() {
        lottoService.result();
    }
}
