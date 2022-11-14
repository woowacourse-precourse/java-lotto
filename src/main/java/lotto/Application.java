package lotto;

import lotto.controller.LottoController;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        } catch (IllegalArgumentException exception) {
            Output.printErrorMessage(exception.getMessage());
        }
    }
}
