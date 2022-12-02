package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.PlayerNumbers;
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
            int ticketNumber = LottoStore.buyTicketsByBudget(inputView.readBudget()).getTicketNumber();
            outputView.printTicketNumber(ticketNumber);
            PlayerNumbers playerNumbers = PlayerNumbers.issueLottoByTickets(ticketNumber);
            outputView.printPlayerNumbers(playerNumbers);

            Lotto winningNumbers = new Lotto(inputView.readWinningNumbers());

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}
