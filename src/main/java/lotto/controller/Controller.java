package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.service.Purchase;
import lotto.service.Statistics;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        Purchase purchase = new Purchase(Input.inputPurchaseAmount());
        Winning winning = new Winning();

        List<Lotto> lotteries = purchase.issueLotteries();
        Output.printLotteries(lotteries);
        winning.setWinningNumbers(Input.inputWinningNumbers());
        winning.setBonusNumber(Input.inputBonusNumber());

        Statistics statistics = new Statistics(winning, lotteries);
        Output.printStatistics(statistics.winningResult(), statistics.yield());
    }
}
