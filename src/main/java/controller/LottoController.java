package controller;

import lotto.LottoPurchase;
import lotto.LottoTickets;
import org.mockito.internal.matchers.Null;
import view.Input;
import view.Output;

public class LottoController {
    public void implement() {
        LottoPurchase purchase = inputMoney();
        LottoTickets lottoTickets = changeTickets(purchase);
    }

    private LottoPurchase inputMoney() {
        try {
            return new LottoPurchase(Input.inputMoney());
        } catch (IllegalArgumentException exception) {
            Output.outputException(exception);
            return inputMoney();
        }
    }

    private LottoTickets changeTickets(LottoPurchase money) {
        int count = money.calculateTicketCount();
        Output.outputTicketCount(count);

        LottoTickets lottoTickets = new LottoTickets(count);
        Output.outputTicket(lottoTickets);
        return lottoTickets;
    }
}
