package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.WinningLotto;
import lotto.View.InputView;

public class InputController {
    public static Buyer inputPurchaseAmount(){
        return new Buyer(InputView.purchaseAmountInput());
    }

    public static WinningLotto inputWinningLotto(){
        return new WinningLotto(InputView.WinningLottoInput(), InputView.BonusLottoInput());
    }
}
