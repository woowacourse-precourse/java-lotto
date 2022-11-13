package lotto.controller;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start(){
        LottoMoney money = input();
        LottoTicket tickets = buyTickets(money);
    }

    private LottoMoney input(){
        return new LottoMoney(InputView.moneyAmount());
    }

    private LottoTicket buyTickets(LottoMoney amount){
        int tickets = amount.calculateLottoTicket();
        OutputView.printLottoTicket(tickets);

        return new LottoTicket(tickets);
    }
}
