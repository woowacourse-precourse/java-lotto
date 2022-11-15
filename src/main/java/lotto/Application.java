package lotto;

import lotto.domain.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game();
            game.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
