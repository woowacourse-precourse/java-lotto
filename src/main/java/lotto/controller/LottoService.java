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

    private int payTicket() {
        String moneyInput = inputView.inputMoney();
        int money = validator.validateMoney(moneyInput);
        new PaidMoney(money);
        return money;
    }

    private List<List<Integer>> userTicket(int paidMoney) {
        Ticket ticket = new Ticket(paidMoney);
        int numOfTicket = ticket.getNumOfTicket();
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


    private int announceBonusNumber(List<Integer> winningNumbers) {
        String bonusInput = inputView.inputBonusNumber();
        int bonusNumber = validator.validateBonusNumber(bonusInput);
        new Bonus(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
