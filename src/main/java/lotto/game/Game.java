package lotto.game;

import static lotto.game.UI.*;

import java.util.List;
import lotto.Lotto;

public class Game {
    private Game() {

    }

    public static Game create() {
        return new Game();
    }

    public void start() {
        receiveInput(MESSAGE_PURCHASE_MONEY);
        printPurchasedLottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        receiveInput(MESSAGE_WINNING_NUMBER);
        receiveInput(MESSAGE_BONUS_NUMBER);
        printTotalResult(12.345);
    }
}
