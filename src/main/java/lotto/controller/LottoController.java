package lotto.controller;

import lotto.model.GetMoneyService;
import lotto.model.LottoService;
import lotto.view.InputView;

public class LottoController {
    private LottoService lottoService;

    public LottoController() {
        int money = getMoney();

    }

    private int getMoney() {
        GetMoneyService money = new GetMoneyService(InputView.inputMoney());

        return money.toInt();
    }

}
