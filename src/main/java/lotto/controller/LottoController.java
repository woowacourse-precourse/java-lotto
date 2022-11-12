package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.TicketMachine;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private TicketMachine ticketMachine = new TicketMachine();
    private LottoMaker lottoMaker = new LottoMaker();

    public void process() {
        int ticket = getTicketFromUserByConsole();
    }

    private int getTicketFromUserByConsole() {
        int money = InputView.getMoneyFromUser();
        return ticketMachine.getTicket(money);
    }

}
