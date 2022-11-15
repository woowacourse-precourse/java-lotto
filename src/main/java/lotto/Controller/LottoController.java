package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoSystem;
import lotto.Model.Money;
import lotto.Model.RandomLotto;
import lotto.View.InputView;
import lotto.View.OutputView;


public class LottoController {

    public void lottoStart() {
        try{
            int temp = InputView.inputAmount();

            new Money(temp);

            RandomLotto.BuyNewLotto();

            OutputView.printBundleOfLottoNumbers();

            inputNumbers();

            LottoSystem.lottoSystem(Lotto.getWinningNumbers(), Lotto.getBonusNumber());

            printTotalResult();
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
        }

    }

    private void printTotalResult() {
        OutputView.printResult();
        OutputView.printYield();
    }

    private void inputNumbers() {
        InputView.printWinningNumberInput();
        InputView.printBonusNumberInput();
    }
}
