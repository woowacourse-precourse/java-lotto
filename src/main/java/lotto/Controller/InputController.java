package lotto.Controller;

import lotto.Model.Buyer;
import lotto.View.InputView;

public class InputController {
    public static Buyer getPurchaseAmount(){
        try {
            return new Buyer(InputView.purchaseAmountInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
