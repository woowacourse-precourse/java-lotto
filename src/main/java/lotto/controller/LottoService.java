package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public void start() {
        int paidMoney = payTicket();
        List<List<Integer>> lottoTickets = userTicket(paidMoney);
        List<Integer> winningNumbers = announceWinningNumbers();
        int bonusNumber = announceBonusNumber(winningNumbers);
        Comparator comparator = compareUserTicket(lottoTickets, winningNumbers, bonusNumber);
        checkEarnedRate(comparator, paidMoney);
    }

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

    private Comparator compareUserTicket(
            List<List<Integer>> lottoTickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        Comparator comparator = new Comparator(lottoTickets, winningNumbers, bonusNumber);
        LinkedHashMap<Prize, Integer> winningTickets = comparator.countWinningTickets();
        outputView.printPrize(winningTickets);
        return comparator;
    }

    private void checkEarnedRate(Comparator comparator, int paidMoney) {
        float earnedRate = comparator.calculateEarnedRate(paidMoney);
        outputView.printRate(earnedRate);
    }
}
