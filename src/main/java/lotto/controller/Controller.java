package lotto.controller;

import lotto.domain.Purchase;
import lotto.domain.Statistic;
import lotto.domain.Winning;

public class Controller {
    public Controller() {
        String purchaseInput = Purchase.purchaseAmountInput();
        Purchase purchase = new Purchase(purchaseInput);
        purchase.printPurchaseLotteries();

        String winningNumberInput = Winning.winningNumberInput();
        String bonusNumberInput = Winning.bonusNumberInput();
        Winning winning = new Winning(winningNumberInput, bonusNumberInput);

        Statistic statistic = new Statistic(purchase, winning);
        statistic.printWinningStatisticResult();
    }
}
