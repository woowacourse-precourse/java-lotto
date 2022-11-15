package lotto;

import lotto.controller.GameController;

public class LottoGame {
    private final GameController gameController = new GameController();

    public void playGame() {
        try {
            gameController.buyLotto();
            gameController.checkWinningNumbers();
            gameController.getResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
