package lotto;

import controller.MoneyController;
import view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.start();
    }
}
