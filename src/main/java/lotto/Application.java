package lotto;

import lotto.Controller.LottoController;
import lotto.Controller.WinningNumberController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        WinningNumberController winningNumberController = new WinningNumberController();

        try {
            lottoController.start();
            winningNumberController.start();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
