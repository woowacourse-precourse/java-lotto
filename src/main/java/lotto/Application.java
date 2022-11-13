package lotto;

import lotto.controller.LottoController;
import lotto.validator.Validator;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        new LottoController(new LottoView(new Validator())).start();
    }
}
