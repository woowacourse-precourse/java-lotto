package lotto;

import lotto.domain.Lotto;
import lotto.domain.Manager;
import lotto.ui.Input;
import lotto.ui.Ouput;

import java.util.List;

public class System {
    Manager manager = new Manager();
    Input input = new Input();
    Ouput ouput = new Ouput();

    public void purchaseLottoTable() {
        ouput.notifyHowMuchInput();
        int money = input.getUserMoney();
        int amount = manager.getAmount(money);
        manager.purchaseLotto(amount);
        ouput.notifyPurchasedLottoTable(manager.getLottoTable());
    }

    public List<Integer> compareWinningLottoNumbers() {
        ouput.notifyWinningLottoNumbersInput();
        Lotto winningLotto = new Lotto(input.getWinningLottoNumbers());
        ouput.notifyBonusNumberInput();
        int bounusNumber = input.getBonusNumber();
        List<Integer> result = manager.compareLottoTable(manager.getLottoTable(), winningLotto, bounusNumber);
        return manager.sumUpResult(result);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        ouput.notifySumOfResult(sumOfResult);
        float rateOfReturn = manager.getRateOfReturn(sumOfResult);
        ouput.notifyRateOfReturn(rateOfReturn);
    }
}


