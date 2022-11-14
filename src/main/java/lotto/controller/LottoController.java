package lotto.controller;

import lotto.domain.LottoAmount;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        LottoAmount amount = inputAmount();
        LottoTicket lottoTicket = buyTickets(amount);
    }

    private LottoAmount inputAmount() {
        try {
            return new LottoAmount(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private LottoTicket buyTickets(LottoAmount amount) {
        int ticketCount = amount.calculateLottoCount();
        OutputView.printTicketCount(ticketCount);

        LottoTicket lottoTicket = new LottoTicket(ticketCount);
        OutputView.printTicket(lottoTicket);
        return lottoTicket;
    }
}
