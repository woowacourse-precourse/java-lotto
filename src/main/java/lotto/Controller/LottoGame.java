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
        getAmount();
        buyLotto();
        showUserLotto();
        getWinningNumber();
        showWinningNumber();

        bonusNumber = InputView.getBonusNumber(winningNumber);
        showStatistics();
    }

    public void getAmount() {
        OutputView.askMoney();
        String input = InputView.getInput();
        MoneyValidator.validateMoney(input);
        int count = InputView.calculateAmount(input);
        OutputView.printAmount(count);
        this.amount = count;
    }

    public void buyLotto() {
        userLotto = LottoMachine.publishLotto(amount);
    }

    public void showUserLotto() {
        OutputView.printUserLotto(userLotto);
    }

    public void getWinningNumber() {
        String input = InputView.getInput();
        Lotto lotto = InputView.calculateWinningNumber(input);
        LottoValidator.validateWinningNumber(lotto);
        winningNumber = lotto;
    }

    public void showWinningNumber() {
        OutputView.printWinningNumber();
    }

    public void showStatistics() {
        OutputView.printStatistics(amount, LottoMachine.calculateResult(userLotto, winningNumber, bonusNumber));
    }
}