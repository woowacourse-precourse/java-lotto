package lotto;

import lotto.exception.ExceptionView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            ExceptionView.println(e.getMessage());
        }
    }
}
