package lotto;

import lotto.controller.GameController;
import lotto.log.Log;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }
}
