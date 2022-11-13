package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class InputController {
    public static Buyer inputPurchaseAmount(){
        return new Buyer(InputView.purchaseAmountInput());
    }

    public static Lotto inputWinningLotto(){
        return new Lotto(InputView.WinningLottoInput());
    }
}
