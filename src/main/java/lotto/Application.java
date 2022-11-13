package lotto;

import lotto.Controller.LottoController;
import lotto.Controller.WinningNumberController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        WinningNumberController winningNumberController = new WinningNumberController();

        lottoController.start();
        winningNumberController.start();
    }
}
