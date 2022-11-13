package lotto.Controller;

import lotto.Model.Buyer;
import lotto.Model.Calculator;
import lotto.Model.WinningLotto;
import lotto.View.InputView;

public class LottoController {

    public static Calculator makeCalculator(Buyer buyer, WinningLotto winningLotto){
        return new Calculator(winningLotto.makeRankResult(buyer));
    }

}
