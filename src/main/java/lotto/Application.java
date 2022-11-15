package lotto;

import controller.GameController;


public class Application {
    final static int MAX_LOTTO_LENGTH = 6;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameController gameController = new GameController();
        gameController.runGame();
    }
}
