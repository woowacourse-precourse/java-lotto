package lotto.Controller;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.Validator.LottoValidator;
import lotto.Validator.MoneyValidator;
import lotto.View.InputView;
import lotto.View.OutputView;

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
        Lotto lotto = LottoMachine.calculateWinningNumber(input);
        winningNumber = lotto;
    }

    public void getBonusNumber() {
        int input = Integer.parseInt(InputView.getNumber());
        LottoValidator.validateBonusNumber(winningNumber, input);
        bonusNumber = input;
    }

    public void showStatistics() {
        OutputView.printStatistics(amount, LottoMachine.calculateResult(userLotto, winningNumber, bonusNumber));
    }
}