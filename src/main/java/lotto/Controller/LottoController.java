package lotto.Controller;

import lotto.Domain.Buyer;
import lotto.Domain.Calculator;
import lotto.Domain.WinningLotto;
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
