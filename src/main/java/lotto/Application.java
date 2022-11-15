package lotto;

import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController.run();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
        }
    }
}
