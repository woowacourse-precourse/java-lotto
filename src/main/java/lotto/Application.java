package lotto;

import lotto.utils.game.GameStatus;

public class Application {

    public static void main(String[] args) {
        GameRunner.run(GameStatus.PURCHASE_AMOUNT);
    }
}
