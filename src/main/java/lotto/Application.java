package lotto;

import lotto.controller.LottoController;

public class Application {

    private static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        lottoController.run();
    }
}
