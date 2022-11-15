package lotto.controller;

import lotto.model.Referee;
import lotto.model.Lotto.BonusLotto;
import lotto.model.Lotto.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class EventController {

    private User user;
    private Referee referee;
    private Lotto lotto;
    private BonusLotto bonusLotto;

    private int inputMoneyForBuyTickets() {
        int money = InputView.inputMoney();
        return money;
    }

    private int calculateTicketCount(int money) {
        int count = money / 1000;
        OutputView.printCountOfTicket(count);
        return count;
    }

    public void raffleTickets(int count) {
        user = new User(count);
        user.setTickets();

        OutputView.printNumberOfEachLotto(user.getTickets());
    }
}
