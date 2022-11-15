package lotto.controller;

import lotto.view.OutputView;

public class LottoController {

    private OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        try {

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }



}
