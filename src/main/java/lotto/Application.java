package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController();
        try {
            game.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
