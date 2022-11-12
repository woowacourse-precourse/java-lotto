package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        generateByAmount();
    }

    private void generateByAmount(){
        outputView.printWithLine(OutputView.INPUT_AMOUNT);
        int amount = inputView.inputAmount();
        lottoService.generateByAmount(amount);
        outputView.printWithLine(amount + OutputView.BUY_COMPLETE);
        outputView.print(lottoService.showLottos());
    }

}
