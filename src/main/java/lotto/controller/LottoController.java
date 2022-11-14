package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    LottoService lottoService;

    public void run() {
        setLottery();
        startLottery()
        endLottery()
    }

    private void setLottery() {
        lottoService = new LottoService();
    }

    private void startLottery() {
        lottoService.drawLotteries();
    }

    private void endLottery() {
        lottoService.returnResult();
    }
}
