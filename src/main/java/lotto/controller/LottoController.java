package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Lottos lottos = LottosGenerator.generate(new Money(InputView.inputMoney()));
        OutputView.printLotto(lottos.getLottos());

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());

        LottoResult result = lottos.getResult(winningLotto, bonusNumber);
        OutputView.printLottoResult(result);
    }
}
