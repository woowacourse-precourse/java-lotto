package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Calculator;
import lotto.Model.WinningLotto;
import lotto.View.OutputView;

public class LottoController {

    public LottoController() {
        activate();
    }

    public static Calculator makeCalculator(Buyer buyer, WinningLotto winningLotto) {
        return new Calculator(winningLotto.makeRankResult(buyer));
    }

    private void playLotto() {
        Buyer buyer = InputController.inputPurchaseAmount();
        buyer.addLotto();
        OutputView.printBuyerLotto(buyer);
        WinningLotto winninglotto = InputController.inputWinningLotto();
        Calculator calculator = LottoController.makeCalculator(buyer, winninglotto);
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
