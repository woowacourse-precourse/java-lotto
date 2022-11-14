package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
