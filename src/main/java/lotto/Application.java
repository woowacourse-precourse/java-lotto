package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);

        gameController.play();
    }
}
