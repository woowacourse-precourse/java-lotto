package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoSystem;
import lotto.Model.RandomLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    public void lottoStart() {

        InputView.inputAmount();

        RandomLotto.BuyNewLotto();

        inputNumbers();

        LottoSystem.lottoSystem(Lotto.getWinningNumbers(), Lotto.getBonusNumber());

        printTotalResult();
    }

    private static void printTotalResult() {
        OutputView.printResult();
        OutputView.printYield();
    }

    private static void inputNumbers() {
        InputView.printWinningNumberInput();
        InputView.printBonusNumberInput();
    }
}
