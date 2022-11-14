package lotto;

import lotto.Controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.startGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }
    }
}
