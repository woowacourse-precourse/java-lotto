package lotto.domain;

import lotto.view.InputView;

public class LottoGame {

    public void start() {
        Money money = new Money(InputView.inputPurchaseMoney());
    }
}
