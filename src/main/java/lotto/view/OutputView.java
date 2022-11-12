package lotto.view;

import lotto.model.LottoTickets;

public class OutputView {

    public void outputToLottoTickets(Messages message, LottoTickets lottoTickets) {

        System.out.printf((message.getMessage()) + "%n", lottoTickets.getTicketCounts());
        System.out.println(lottoTickets);
    }
}
