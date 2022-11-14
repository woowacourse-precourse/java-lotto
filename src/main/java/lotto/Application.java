package lotto;

import lotto.controller.LottoController;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}