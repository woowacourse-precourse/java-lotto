package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.ProfitCalculator;
import lotto.domain.LottoChecker;
import lotto.ui.Input;
import lotto.ui.Ouput;

import java.util.List;

public class Operator {
    ProfitCalculator profitCalculator = new ProfitCalculator();
    LottoMachine lottoMachine = new LottoMachine();
    LottoChecker lottoChecker = new LottoChecker();
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
        return lottoChecker.toResult(
                lottoChecker.compareLottoTable(lottoMachine.getLottoTable(), winningLotto, bounusNumber));
    }

    public void notifyResult(List<Integer> result) {
        ouput.notifyResult(result);
        float rateOfProfit = profitCalculator.toRateOfProfit(result);
        ouput.notifyRateOfProfit(rateOfProfit);
    }
}


