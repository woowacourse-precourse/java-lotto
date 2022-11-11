package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.printRequest();

    }
}
