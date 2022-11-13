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

    public void purchaseLottoTable() {
        ouput.notifyHowMuchInput();
        int money = input.getUserMoney();
        System.out.println();

        lottoMachine.purchaseLottoTable(money);
        ouput.notifyPurchasedLottoTable(lottoMachine.getLottoTable());
        System.out.println();
    }

    public List<Integer> compareWinningLottoNumbers() {
        ouput.notifyWinningLottoNumbersInput();
        Lotto winningLotto = new Lotto(input.getWinningLottoNumbers());
        System.out.println();
        ouput.notifyBonusNumberInput();
        int bounusNumber = input.getBonusNumber();
        System.out.println();

        return winnerChecker.getSumOfResult(lottoMachine.getLottoTable(), winningLotto, bounusNumber);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        ouput.notifySumOfResult(sumOfResult);
        float rateOfReturn = profitCalculator.getRateOfReturn(sumOfResult);
        ouput.notifyRateOfReturn(rateOfReturn);
    }
}


