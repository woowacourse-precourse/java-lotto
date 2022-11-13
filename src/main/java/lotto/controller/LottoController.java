package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssueMachine;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money money = InputView.inputMoney();
        List<Lotto> lottos = LottoIssueMachine.issue(money.calculateQuantity());
        OutputView.printLottos(lottos);
        Lotto winningNumbers = InputView.inputWinningNumbers();
    }
}
