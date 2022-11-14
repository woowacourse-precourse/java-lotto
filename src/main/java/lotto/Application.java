package lotto;

import lotto.controller.LottoController;
import lotto.utils.Validator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();

        lottoController.start();
    }
}
