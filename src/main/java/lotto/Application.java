package lotto;

import lotto.domain.Game;

public class Application {

    public static void main(String[] args) {
        Game lottoGame = new Game();
        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
