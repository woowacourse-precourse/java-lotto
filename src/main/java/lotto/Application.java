package lotto;

import lotto.presentation.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        try {
            game.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
