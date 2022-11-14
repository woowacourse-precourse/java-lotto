package lotto.Controller;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {
    List<Lotto> userLotto;
    Lotto winningNumber;
    int bonusNumber;

    public void startGame() {
        int amount = InputView.getAmount();
        OutputView.printAmount(amount);

        userLotto = LottoMachine.publishLotto(amount);
        OutputView.printUserLotto(userLotto);

        winningNumber = InputView.getWinningNumber();
        OutputView.printWinningNumber();

        bonusNumber = InputView.getBonusNumber(winningNumber);
        OutputView.printStatistics(amount, LottoMachine.calculateResult(userLotto, winningNumber, bonusNumber));
    }
}