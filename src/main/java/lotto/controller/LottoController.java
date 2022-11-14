package lotto.controller;

import lotto.domain.*;

import static lotto.view.InputView.*;

public class LottoController {

    public LottoController() {
    }

    public void run() {
        Money money = new Money(inputMoney());
        LottoCount lottoCount = new LottoCount(money);
        LottosGenerator lottos = new LottosGenerator(lottoCount);
        String winningNumbers = inputWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber(), winningLotto);
    }
}
