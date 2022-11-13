package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssueMachine;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Money money = InputView.inputMoney();
        List<Lotto> lottos = LottoIssueMachine.issue(money.calculateQuantity());
    }
}
