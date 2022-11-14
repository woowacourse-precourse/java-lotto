package lotto;

import lotto.controller.GameController;

public class LottoGame {
    private final GameController gameController = new GameController();

    public void playGame() {
        gameController.buyLotto();
    }
}
