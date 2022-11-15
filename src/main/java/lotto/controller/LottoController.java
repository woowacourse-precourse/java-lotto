package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
}