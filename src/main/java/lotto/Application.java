package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        try {
            GameController gameController = new GameController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
