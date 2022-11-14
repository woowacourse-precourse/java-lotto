package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());
        lottoController.run();
    }
}
