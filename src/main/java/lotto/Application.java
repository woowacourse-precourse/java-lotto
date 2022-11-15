package lotto;

import lotto.domain.Game;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


