package lotto;

import lotto.domain.game.LottoGame;
import lotto.util.View;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            View.printErrorMessage(e);
        }
    }
}
