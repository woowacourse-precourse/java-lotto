package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        GameController gameController = new GameController();
        gameController.run();
    }
}
