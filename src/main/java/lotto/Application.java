package lotto;

import lotto.controller.LottoController;

import static lotto.view.OutputView.printErrorMessage;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
