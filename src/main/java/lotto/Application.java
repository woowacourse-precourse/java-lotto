package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {

        LottoGame game = new LottoGame();
        boolean go = game.start();
        if (go == true) game.play();
        if (go == true) game.result();
    }
}
