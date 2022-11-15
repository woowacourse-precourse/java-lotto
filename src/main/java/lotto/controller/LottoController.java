package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private int moneyAmount;

    private User user = new User();

    public void buyLotto() {
        InputView.requestAmount();
        moneyAmount = user.inputOfMoneyAmount();
        int lottoAmount = moneyAmount / 1000;
        OutputView.printAmount(lottoAmount);
    }
}
