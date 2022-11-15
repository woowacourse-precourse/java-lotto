package lotto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Player;
import lotto.domain.PrizeCount;
import lotto.domain.Profit;
import lotto.domain.Purchase;

public class GameRunner {

    private Purchase purchase;
    private PrizeCount prizeCount;
    private Player player;
    private Profit profit;

    private List<Integer> numbers;
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
        purchase.createLottos();
        purchase.printLottos();
        purchase.createBonusNumber();
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
        player.compare(prizeCount, purchase.getLottos(), purchase.getBonusNumber());

        profit = new Profit(prizeCount, purchase.getAmount());
        profit.calculate();
    }

    private void printResult() {
        printWinningStatisticsMessage();
        System.out.println(prizeCount);
        System.out.println(profit);
    }
}
