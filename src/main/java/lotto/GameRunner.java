package lotto;

import static lotto.view.InputView.getInt;
import static lotto.view.InputView.getNumbers;
import static lotto.view.OutputView.askBonusNumber;
import static lotto.view.OutputView.askNumbers;
import static lotto.view.OutputView.askPurchaseAmount;
import static lotto.view.OutputView.printLottos;
import static lotto.view.OutputView.printWinningStatisticsMessage;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PrizeCount;
import lotto.domain.Profit;
import lotto.domain.Purchase;

public class GameRunner {

    private Purchase purchase;
    private PrizeCount prizeCount;
    private Player player;
    private Profit profit;

    private List<Lotto> lottos;
    private List<Integer> numbers;
    private int lottoBonusNumber;
    private int bonusNumber;

    public void start() {
        inputPurchaseAmount();

        purchaseLottos();

        inputNumbers();

        inputBonusNumber();

        makeResult();

        printResult();
    }

    private void inputPurchaseAmount() {
        askPurchaseAmount();

        purchase = new Purchase(getInt());
        purchase.printCount();
    }

    private void purchaseLottos() {
        lottos = purchase.createLottos();
        printLottos(lottos);

        lottoBonusNumber = purchase.createLottoBonusNumber();
    }

    private void inputNumbers() {
        askNumbers();
        numbers = getNumbers();
    }

    private void inputBonusNumber() {
        askBonusNumber();
        bonusNumber = getInt();
    }

    private void makeResult() {
        prizeCount = new PrizeCount();

        player = new Player(numbers, bonusNumber);
        player.compare(prizeCount, lottos, lottoBonusNumber);

        profit = new Profit(prizeCount, purchase.getAmount());
        profit.calculate();
    }

    private void printResult() {
        printWinningStatisticsMessage();
        System.out.println(prizeCount);
        System.out.println(profit);
    }
}
