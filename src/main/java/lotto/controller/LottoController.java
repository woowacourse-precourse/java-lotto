package lotto.controller;

import lotto.model.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            LottoStore lottoStore = LottoStore.buyTicketsByBudget(inputView.readBudget());
            outputView.printTicketNumber(lottoStore.getTicketNumber());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}
