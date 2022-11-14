package lotto;

import Service.LottoService;
import Service.WinningService;
import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController();
        lottoController.run();

    }
}