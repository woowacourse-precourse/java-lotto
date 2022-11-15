package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoFactory lottoFactory = new LottoFactory();

        LottoController lottoController = new LottoController(inputView, outputView, lottoFactory);
        lottoController.run();
    }
}
