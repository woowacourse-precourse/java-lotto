package lotto;

import lotto.controllers.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        try {
            gameController.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
