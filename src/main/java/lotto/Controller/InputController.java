package lotto.Controller;

import lotto.Domain.Buyer;
import lotto.Domain.Calculator;
import lotto.Domain.WinningLotto;
import lotto.View.InputView;

public class InputController {

    public static Buyer inputPurchaseAmount() {
        return new Buyer(InputView.purchaseAmountInput());
    }

    public static WinningLotto inputWinningLotto() {
        return new WinningLotto(InputView.WinningLottoInput(), InputView.BonusLottoInput());
    }

    public static Calculator makeCalculator(Buyer buyer, WinningLotto winningLotto) {
        return new Calculator(winningLotto.makeRankResult(buyer));
    }
}
