package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinnerChecker;
import lotto.ui.Input;
import lotto.ui.Ouput;

import java.util.List;

public class Operator {
    ProfitCalculator profitCalculator = new ProfitCalculator();
    LottoMachine lottoMachine = new LottoMachine();
    WinnerChecker winnerChecker = new WinnerChecker();
    Input input = new Input();
    Ouput ouput = new Ouput();

    public void purchaseLotto() {
        ouput.notifyHowMuchInput();
        int money = input.getUserMoney();
        ouput.beginNewLine();

        lottoMachine.purchaseLottoTable(money);

        ouput.notifyPurchasedLottoTable(lottoMachine.getLottoTable());
        ouput.beginNewLine();
    }

    public List<Integer> checkLotto() {
        ouput.notifyWinningLottoNumbersInput();
        Lotto winningLotto = new Lotto(input.getWinningLottoNumbers());
        ouput.beginNewLine();

        ouput.notifyBonusNumberInput();
        int bounusNumber = input.getBonusNumber();
        ouput.beginNewLine();

        return winnerChecker.getSumOfResult(lottoMachine.getLottoTable(), winningLotto, bounusNumber);
    }

    public void notifyResult(List<Integer> sumOfResult) {
        ouput.notifySumOfResult(sumOfResult);
        float rateOfReturn = profitCalculator.getRateOfReturn(sumOfResult);
        ouput.notifyRateOfReturn(rateOfReturn);
    }
}


