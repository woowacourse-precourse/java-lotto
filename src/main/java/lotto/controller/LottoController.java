package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void run() {
        Money money = new Money(InputView.moneyInput());
        List<Lotto> lottos = new LottoShop(money).buyLotto();
        WinNumbers winNumbers = new WinNumbers(InputView.winNumbersInput(), InputView.bonusNumberInput());

        LottoResult result = new LottoResult(winNumbers, lottos);
        Profit profit = new Profit(money, result.getTotalPrize());

        OutputView.printResult(result);
        OutputView.printProfit(profit.getProfit());
    }
}
