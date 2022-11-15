package lotto.controller;

import lotto.service.LottoService;
import lotto.view.SystemMessage;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void run() {
        purchase();
        raffle();
        check();
    }

    public void purchase() {
        lottoService.getPurchaseMoney();
        lottoService.getLottoCount();
        lottoService.getRandomLottos();
    }

    public void raffle() {
        lottoService.getUserNumber();
        lottoService.getBounsNumber();
    }

    public void check() {
        lottoService.getWinningHistory();
        lottoService.getYeild();
    }
}
