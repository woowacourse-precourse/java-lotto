package lotto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Player;
import lotto.domain.PrizeCount;
import lotto.domain.Profit;
import lotto.domain.Publish;
import lotto.domain.Purchase;

public class GameRunner {

    private Purchase purchase;
    private Publish publish;
    private PrizeCount prizeCount;
    private Player player;
    private Profit profit;

    private List<Integer> numbers;
    private int bonusNumber;

    public void start() {
        inputPurchaseAmount();

        publish();

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

    private void publish() {
        publish = new Publish();
        publish.createLottos(purchase.getCount());
        publish.printLottos();
        publish.createBonusNumber();
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
        player.compare(prizeCount, publish.getLottos(), publish.getBonusNumber());

        profit = new Profit(prizeCount, purchase.getAmount());
        profit.calculate();
    }

    private void printResult() {
        prizeCount.printWinningStatistics();
        profit.printRate();
    }
}
