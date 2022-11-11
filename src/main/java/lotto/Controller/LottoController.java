package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoSystem;
import lotto.Model.Money;
import lotto.Model.RandomLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    public void lottoStart() {

        InputView.inputAmount();

        RandomLotto.BuyNewLotto();

        InputView.printWinningNumberInput();

        InputView.printBonusNumberInput();

        LottoSystem.lottoSystem(Lotto.getWinningNumbers(), Lotto.getBonusNumber());

        OutputView.printResult();

        Money.printYield();
    }
}
