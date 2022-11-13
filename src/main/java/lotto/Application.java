package lotto;


import lotto.Controller.InputController;
import lotto.Controller.LottoController;
import lotto.Model.Buyer;
import lotto.Model.Calculator;
import lotto.Model.WinningLotto;
import lotto.View.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = InputController.inputPurchaseAmount();
        buyer.addLotto();
        OutputView.printBuyerLotto(buyer);
        WinningLotto winninglotto = InputController.inputWinningLotto();

        Calculator calculator = LottoController.makeCalculator(buyer, winninglotto);




    }
}
