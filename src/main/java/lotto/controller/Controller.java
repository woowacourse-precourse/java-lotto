package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class Controller {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        WinningNumbers winningNumbers = inputWinningNumbersAndBonusNumber();

    }

    public LottoPurchaseAmount inputMoney() {
        return new LottoPurchaseAmount(InputView.inputAmount());
    }

    public WinningNumbers inputWinningNumbersAndBonusNumber() {
        return InputView.inputWinningNumbersAndBonus();
    }

    public void inputBonusNumber() {

    }

    public void createWinningStatistics() {

    }
}
