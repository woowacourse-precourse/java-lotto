package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController(new LottoService());

            lottoController.play();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
