package lotto;

import lotto.caculation.Money;
import lotto.caculation.Purchase;
import lotto.caculation.Yield;
import lotto.reward.Lotto;
import lotto.reward.Numbers;
import lotto.reward.WinningCase;
import lotto.utils.WinningType;
import lotto.view.Input;
import lotto.view.Result;

import java.util.Map;

public class Application {
    public void StartLotto() {
        Money money = Input.inputMoney();
        collectYield(money, getWinningResult(buyLotto(money)));
    }

    private Purchase buyLotto(Money money) {
        Purchase purchasing = new Purchase(money);
        Result.printLottoEA(purchasing.getLottoCount());
        Result.printLottos(purchasing.getLottoTickets());
        return purchasing;
    }

    private Map<WinningType, Integer> getWinningResult(Purchase purchasing) {
        Lotto winningLotto = new Lotto(Input.inputRewardNumber());
        Numbers bonus = Input.inputBonusNumber();
        return purchasing.getWinningResult(new WinningCase(winningLotto, bonus));
    }

    private void collectYield(Money money, Map<WinningType, Integer> winningResult) {
        Yield yield = new Yield(winningResult);
        Map<WinningType, Integer> result = yield.getYield();
        Result.printResultMessage();
        Result.printStatistics(result);
        Result.printRateOfReturn(yield.getYieldOfLotto(money));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application LottoPlayer = new Application();
        LottoPlayer.StartLotto();
    }
}
