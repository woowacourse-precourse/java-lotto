package lotto;

import lotto.controller.LottoController;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        new LottoController(new Input(), new Output()).start();
    }
}
