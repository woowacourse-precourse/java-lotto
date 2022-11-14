package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    // 로또 게임 시작 기능
    public void playLottoGame() {
        lottoService.buyLotto();
        lottoService.inputWinningNumber();
        lottoService.showLottoYield();
    }
}
