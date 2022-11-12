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
        List<Lotto> lottos = getRandomLottoBy(ticket);
    }

    private int getTicketFromUserByConsole() {
        int money = InputView.getMoneyFromUser();
        int ticket = ticketMachine.getTicket(money);
        OutputView.printNumberOfIssuedLotto(ticket);
        return ticket;
    }

    private List<Lotto> getRandomLottoBy(int ticket) {
        List<Lotto> lottos = lottoMaker.getRandomLottos(ticket);
        OutputView.printLottosInformation(lottos);
        return lottos;
    }

}
