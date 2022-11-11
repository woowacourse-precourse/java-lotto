package lotto.controller;

import lotto.model.domain.PayingMoney;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PayingMoney payingMoney = new PayingMoney(InputView.requestMoney());
    }
}
