package lotto.Controller;

import lotto.Model.Buyer;
import lotto.View.InputView;
import lotto.View.OutputView;

public class InputController {
    public static void inputPurchaseAmount(Buyer buyer){
//        try{
//            buyer.setPurchaseAmount(InputView.purchaseAmountInput());
//        } catch (IllegalArgumentException e){
//            OutputView.printError(e.getMessage());
//        }
        buyer.setPurchaseAmount(InputView.purchaseAmountInput());
    }
}
