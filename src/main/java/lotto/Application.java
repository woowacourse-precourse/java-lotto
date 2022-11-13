package lotto;


import lotto.Controller.InputController;
import lotto.Model.Buyer;
import lotto.Model.Lotto;
import lotto.View.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = InputController.inputPurchaseAmount();
        buyer.addLotto();
        OutputView.printBuyerLotto(buyer);
        Lotto lotto = InputController.inputWinningLotto();
    }
}
