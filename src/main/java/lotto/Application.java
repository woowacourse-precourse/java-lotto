package lotto;

import lotto.controller.LottoController;
import lotto.view.InputViewConsole;
import lotto.view.OutputViewConsole;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(new InputViewConsole(), new OutputViewConsole()).run();
    }
}
