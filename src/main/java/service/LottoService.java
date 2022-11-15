package service;

import controller.LottoController;

public class LottoService {

    private final LottoController lottoController;

    public LottoService(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void game() {
        lottoController.calculate();
    }
}
