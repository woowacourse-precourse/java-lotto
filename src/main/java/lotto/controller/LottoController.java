package lotto.controller;

import lotto.model.GetMoneyService;
import lotto.view.InputView;

public class LottoController {
    public LottoController() {
        getMoney();
    }

    private void getMoney() {
        GetMoneyService money = new GetMoneyService(InputView.inputMoney());
    }
}
