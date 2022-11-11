package lotto.controller;

import lotto.service.LottoService;
import lotto.view.input.Input;

public class LottoController {

    LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            int money = lottoService.getMoney();
            lottoService.buyLotto(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
