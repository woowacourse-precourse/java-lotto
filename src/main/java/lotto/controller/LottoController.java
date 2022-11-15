package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottosGenerator;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Lottos lottos = LottosGenerator.generate(new Money(InputView.inputMoney()));
        OutputView.printLotto(lottos.getLottos());

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
    }
}
