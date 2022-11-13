package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinnerChecker;
import lotto.ui.Input;
import lotto.ui.Ouput;

import java.util.List;

public class Operator {
    ProfitCalculator manager = new ProfitCalculator();
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
        List<Integer> result = winnerChecker.compareLottoTable(lottoMachine.getLottoTable(), winningLotto, bounusNumber);
        return winnerChecker.sumUpResult(result);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        ouput.notifySumOfResult(sumOfResult);
        float rateOfReturn = manager.getRateOfReturn(sumOfResult);
        ouput.notifyRateOfReturn(rateOfReturn);
    }
}


