package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.TicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private TicketMachine ticketMachine = new TicketMachine();
    private LottoMaker lottoMaker = new LottoMaker();

    public void process() {
        int ticket = getTicketFromUserByConsole();
    }

    private int getTicketFromUserByConsole() {
        int money = InputView.getMoneyFromUser();
        int ticket = ticketMachine.getTicket(money);
        OutputView.printNumberOfIssuedLotto(ticket);
        return ticket;
    }

}
