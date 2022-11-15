package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Calculator;
import lotto.Model.WinningLotto;
import lotto.View.OutputView;

public class LottoController {

    public LottoController() {
        activate();
    }


    private void playLotto() {
        Buyer buyer = InputController.inputPurchaseAmount();
        OutputView.printBuyerLotto(buyer);
        WinningLotto winninglotto = InputController.inputWinningLotto();
        Calculator calculator = InputController.makeCalculator(buyer, winninglotto);
        OutputView.printWinningStatistics(calculator);
    }

    private void activate() {
        try {
            playLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
