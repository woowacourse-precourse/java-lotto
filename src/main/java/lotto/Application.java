package lotto;

import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
