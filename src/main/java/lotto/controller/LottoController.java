package lotto.controller;

import lotto.RateOfReturn;
import lotto.Ticket;
import lotto.Win;
import lotto.validator.Validator;
import lotto.view.LottoView;

import java.util.Collections;
import java.util.List;

public class LottoController {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void start() {
        int money;
        int lottoCount;
        int bonusNumber;
        Ticket ticket;
        Win win;
        double rate;
        RateOfReturn rateOfReturn;
        List<Integer> winningNumbers = Collections.EMPTY_LIST;
        LottoView view = new LottoView(new Validator());

        try {
            view.printMessage(INPUT_MONEY);
            money = view.inputMoney();
            ticket = Ticket.purchase(money);
            ticket.printTickets();
            winningNumbers = view.inputWinningNumbers();
            bonusNumber = view.inputBonusNumber(winningNumbers);
            win = Win.compare(ticket, winningNumbers, bonusNumber);
            rateOfReturn = new RateOfReturn(win, money, view);
            rate = rateOfReturn.calculate();
            win.printWinningStats();
            rateOfReturn.printRate(rate);

        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return;
        }
    }
}
