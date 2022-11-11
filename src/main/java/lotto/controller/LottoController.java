package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoController {
    public static void run() {
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }

}
