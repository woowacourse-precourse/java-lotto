package lotto.domain.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {

    public void run() {
        Money money = Money.from(InputView.getMoneyInput());
    }
}
