package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.PaidMoney;
import lotto.domain.Ticket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    private List<List<Integer>> userTicket() {
        String moneyInput = inputView.inputMoney();
        int money = validator.validateMoney(moneyInput);
        PaidMoney paidMoney = new PaidMoney(money);

        int numOfTicket = paidMoney.buyNTicket();
        Ticket ticket = new Ticket(numOfTicket);
        List<List<Integer>> lottoTickets = ticket.purchaseTickets();
        outputView.printTickets(numOfTicket, lottoTickets);

        return lottoTickets;
    }


    private List<Integer> announceWinningNumbers() {
        String numbersInput = inputView.inputWinningNumbers();
        List<Integer> winningNumbers = validator.validateWinningNumbers(numbersInput);
        new Lotto(winningNumbers);
        return winningNumbers;
    }
}
