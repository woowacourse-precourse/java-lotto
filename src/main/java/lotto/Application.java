package lotto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Purchase;

public class Application {

    public static void main(String[] args) {
        askPurchaseAmount();

        Purchase purchase = new Purchase(getInt());
        purchase.printCount();

        List<Lotto> lottos = purchase.createLottos();
        printLottos(lottos);

        askNumbers();
        List<Integer> numbers = getNumbers();

        askBonusNumber();
        int bonusNumber = getInt();

        Player player = new Player(numbers, bonusNumber);
        player.compare(lottos);
    }
}
