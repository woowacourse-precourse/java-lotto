package lotto;

import lotto.game.Game;

public class Application {
    public static void main(String[] args) {
        Game game = Game.create();
        game.start();
    }
}
