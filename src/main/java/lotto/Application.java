package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController.runGame();
        } catch (IllegalArgumentException exception) {
            GameController.informExitByError(exception);
        }
    }
}