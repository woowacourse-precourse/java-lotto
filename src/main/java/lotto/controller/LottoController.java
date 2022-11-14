package lotto.controller;

import lotto.domain.LuckyNumber;
import lotto.service.LottoService;

public class LottoController {

    LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int money = lottoService.getMoney();
        lottoService.buyLotto(money);
        LuckyNumber luckyNumber = lottoService.pickLuckyNumber();
        lottoService.printResult(luckyNumber, money);
    }
}
