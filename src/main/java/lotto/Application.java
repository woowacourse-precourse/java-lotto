package lotto;

import lotto.domain.Game;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.runGame();
        }catch (IllegalArgumentException e){
            return;
        }
    }
}
