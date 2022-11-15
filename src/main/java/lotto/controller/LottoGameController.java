package lotto.controller;

import static lotto.view.InputView.askBonusNumber;
import static lotto.view.InputView.askNumbers;
import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.OutputView.printLottoQuantity;
import static lotto.view.OutputView.printLottos;
import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printStatistics;

import java.util.List;
import lotto.Lotto;
import lotto.LottosGenerator;
import lotto.Profit;
import lotto.Quantity;
import lotto.Referee;
import lotto.WinningStat;

public class LottoGameController {

    private final LottosGenerator lottosGenerator;
    private final Referee referee;
    private Quantity quantity;
    private List<Lotto> lottos;
    private List<WinningStat> winningStats;
    private Profit profit;

    public LottoGameController() {
        lottosGenerator = new LottosGenerator();
        referee = new Referee();
    }

    public void gameStart() {
        enterPurchaseAmount();

        printLottoQuantity(quantity);
        printLottos(lottos);

        enterPlayerNumberAndBonusNumber();

        printStatistics(winningStats);
        printProfit(profit, quantity);
    }

    public void enterPurchaseAmount() {
        int purchaseAmount = askPurchaseAmount();
        this.quantity = new Quantity(purchaseAmount);
        this.lottos = lottosGenerator.createLottos(this.quantity);
    }

    public void enterPlayerNumberAndBonusNumber() {
        List<Integer> playerNumbers = askNumbers();
        int bonusNumber = askBonusNumber(playerNumbers);

        this.winningStats = referee.compare(lottos, playerNumbers, bonusNumber);
        this.profit = new Profit(winningStats);
    }
}
