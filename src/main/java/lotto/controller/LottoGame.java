package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    List<Lotto> userLotto;
    Lotto winningNumber;
    int bonusNumber;
    int amount;

    public void startGame() {
        try {
            getAmount();
            buyLotto();
            showUserLotto();
            getWinningNumber();
            getBonusNumber();
            showStatistics();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }
    }

    public void getAmount() {
        String input = InputView.getMoney();
        MoneyValidator.validateMoney(input);
        int count = LottoMachine.calculateAmount(input);
        this.amount = count;
    }

    public void buyLotto() {
        userLotto = LottoMachine.publishLotto(amount);
    }

    public void showUserLotto() {
        OutputView.printUserLotto(userLotto);
        System.out.println();
    }

    public void getWinningNumber() {
        String input = InputView.getNumbers();
        LottoValidator.validateWinningNumber(input);
        Lotto lotto = LottoMachine.calculateWinningNumber(input);
        winningNumber = lotto;
    }

    public void getBonusNumber() {
        String input = InputView.getNumber();
        LottoValidator.validateBonusNumber(winningNumber, input);
        bonusNumber = Integer.parseInt(input);
    }

    public void showStatistics() {
        OutputView.printStatistics(amount, LottoMachine.calculateResult(userLotto, winningNumber, bonusNumber));
    }
}