package lotto;

import lotto.business.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
