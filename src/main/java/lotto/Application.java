package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gamController = new GameController();
        gamController.run();
    }
}
