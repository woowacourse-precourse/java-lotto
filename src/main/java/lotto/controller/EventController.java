package lotto.controller;

import lotto.model.Referee;
import lotto.model.Lotto.BonusLotto;
import lotto.model.Lotto.Lotto;
import lotto.model.User;
import lotto.view.InputView;

public class EventController {

    private User user;
    private Referee referee;
    private Lotto lotto;
    private BonusLotto bonusLotto;

    private int inputMoneyForBuyTickets() {
        int money = InputView.inputMoney();
        return money;
    }
}
