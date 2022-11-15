package lotto;

import lotto.controller.LottoGame;
import lotto.view.LottoPrinter;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.play();
        } catch (IllegalArgumentException ex) {
            LottoPrinter lottoPrinter = new LottoPrinter();
            lottoPrinter.printErrorMessage(ex.getMessage());
        }
    }
}
