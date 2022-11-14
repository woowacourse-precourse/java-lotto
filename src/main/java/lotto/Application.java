package lotto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PrizeCount;
import lotto.domain.Profit;
import lotto.domain.Purchase;

public class Application {

    public static void main(String[] args) {
        askPurchaseAmount();

        Purchase purchase = new Purchase(getInt());
        purchase.printCount();

        List<Lotto> lottos = purchase.createLottos();
        printLottos(lottos);

        int lottoBonusNumber = purchase.createLottoBonusNumber();

        askNumbers();
        List<Integer> numbers = getNumbers();

        askBonusNumber();
        int bonusNumber = getInt();

        PrizeCount prizeCount = new PrizeCount();
        Player player = new Player(numbers, bonusNumber);

        player.compare(prizeCount, lottos, lottoBonusNumber);
        Profit profit = new Profit(prizeCount, purchase.getAmount());

    }
}
