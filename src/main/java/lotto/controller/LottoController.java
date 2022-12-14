package lotto.controller;

import lotto.util.InputValidator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView = new InputView();

    public void run() {
        InputValidator.validateInputPrice(inputView.inputPrice());
    }
}
