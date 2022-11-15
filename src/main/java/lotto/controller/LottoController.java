package lotto.controller;

import lotto.model.Money;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        Money money = new Money(InputView.inputMoney());
    }
}
