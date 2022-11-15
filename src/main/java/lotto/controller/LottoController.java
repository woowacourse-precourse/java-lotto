package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void run() {
        try {
            lottoService.buy();
            lottoService.printLotto();
            lottoService.draw();
            lottoService.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

    }
}
