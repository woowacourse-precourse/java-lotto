package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    LottoService lottoService;

    public void run() {
        try {
            setLottery();
            startLottery();
            endLottery();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setLottery() {
        lottoService = new LottoService();
    }

    private void startLottery() {
        lottoService.drawLotteries();
    }

    private void endLottery() {
        lottoService.printResult();
    }
}
