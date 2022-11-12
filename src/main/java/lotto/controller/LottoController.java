package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void gameStart() {

    }
}
