package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            e.printStackTrace();
        }
    }
}
