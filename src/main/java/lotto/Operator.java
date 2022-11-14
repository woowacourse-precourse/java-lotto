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
        Lotto winning = new Lotto(input.getWinningLottoNumbers());
        ouput.beginNewLine();

        ouput.notifyBonusNumberInput();
        int bounusNumber = input.getBonusNumber();
        ouput.beginNewLine();
        return lottoChecker.toResult(
                lottoChecker.compareLottoTable(lottoMachine.getLottoTable(), winning, bounusNumber));
    }

    public void notifyResult(List<Integer> sumOfResult) {
        ouput.notifySumOfResult(sumOfResult);
        float rateOfProfit = profitCalculator.toRateOfProfit(sumOfResult);
        ouput.notifyRateOfReturn(rateOfProfit);
    }
}


