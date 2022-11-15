package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {

        LottoGame game = new LottoGame();

        try {
            game.start();
            game.play();
            game.result();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
