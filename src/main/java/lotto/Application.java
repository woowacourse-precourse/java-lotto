package lotto;

import controller.GameController;
import factory.LottoGameFactory;

public class Application {
    public static void main(String[] args) {
        GameController gameController = LottoGameFactory.getGame();
        gameController.doGame();
    }
}
