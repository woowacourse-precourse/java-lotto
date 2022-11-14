package lotto.controller;

import lotto.repository.LottoRepository;
import lotto.repository.MoneyRepository;
import lotto.service.LottoService;
import lotto.service.MoneyService;

public class FrontController {

    public void run() {

        MoneyController moneyController = new MoneyController(new MoneyService(new MoneyRepository()));
        int countLotto = moneyController.receiveMoney();

        LottoController lottoController = new LottoController(new LottoService(new LottoRepository()), countLotto);
        lottoController.run();
    }
}
