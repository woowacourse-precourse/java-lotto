package lotto;

import lotto.controller.LottoController;
import lotto.view.InputViewConsole;
import lotto.view.OutputViewConsole;

public class Application {
    public static void main(String[] args) {
        new LottoController(new InputViewConsole(), new OutputViewConsole()).run();
    }
}
