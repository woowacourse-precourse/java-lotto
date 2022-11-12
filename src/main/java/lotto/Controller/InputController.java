package lotto.Controller;

import lotto.Model.Buyer;
import lotto.View.InputView;
import lotto.View.OutputView;

public class InputController {
    public static Buyer inputPurchaseAmount(){
        return new Buyer(InputView.purchaseAmountInput());
    }
}
