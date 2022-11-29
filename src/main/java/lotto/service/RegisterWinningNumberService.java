package lotto.service;

import lotto.domain.WinningLotto;
import lotto.view.InputConsole;

public class RegisterWinningNumberService {
    private final InputConsole inputConsole;

    public RegisterWinningNumberService() {
        this.inputConsole = new InputConsole();
    }

    public WinningLotto register() {
        return new WinningLotto(winningNumbers(), bonusNumber());
    }

    private String winningNumbers() {
        return inputConsole.enterWinningNumber();
    }

    private String bonusNumber() {
        return inputConsole.enterBonusNumber();
    }
}
