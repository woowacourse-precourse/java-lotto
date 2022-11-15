package lotto;

import static lotto.util.NumberValidator.checkNotComma;
import static lotto.util.NumberValidator.checkNotInt;
import static lotto.util.NumberValidator.checkNumbersNotInt;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Player;
import lotto.domain.PrizeCount;
import lotto.domain.Profit;
import lotto.domain.Publisher;
import lotto.domain.Purchase;

public class GameRunner {

    private Purchase purchase;
    private Publisher publisher;
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

        purchase = new Purchase(checkNotInt(input()));
        purchase.printCount();
    }

    private void publish() {
        publisher = new Publisher();
        publisher.createLottos(purchase.getCount());
        publisher.printLottos();
        publisher.createBonusNumber();
    }

    private void inputNumbers() {
        askNumbers();
        numbers = checkNumbersNotInt(checkNotComma(input()));
    }

    private void inputBonusNumber() {
        askBonusNumber();
        bonusNumber = checkNotInt(input());
    }

    private void makeResult() {
        prizeCount = new PrizeCount();

        player = new Player(numbers, bonusNumber);
        player.compare(prizeCount, publisher.getLottos(), publisher.getBonusNumber());

        profit = new Profit(prizeCount, purchase.getAmount());
        profit.calculate();
    }

    private void printResult() {
        prizeCount.printWinningStatistics();
        profit.printRate();
    }
}
