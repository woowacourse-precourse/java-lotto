package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.service.WinningNumberService;
import view.WinningNumberView.BonusNumberView;
import view.WinningNumberView.WinningNumbersView;

public class WinningNumberController {

    private final WinningNumberService winningNumberService;

    public WinningNumberController(WinningNumberService winningNumberService) {
        this.winningNumberService = winningNumberService;
    }

    public WinningNumber enterNumbers() {
        String numbers = enterWinningNumbers();
        String bonusNumber = enterBonusNumber();
        winningNumberService.saveWinningNumber(new WinningNumber(numbers, bonusNumber));
        return winningNumberService.findWinningNumber();
    }

    private String enterWinningNumbers() {
        WinningNumbersView winningNumbersView = new WinningNumbersView();
        return winningNumbersView.show();
    }

    private String enterBonusNumber() {
        BonusNumberView bonusNumberView = new BonusNumberView();
        return bonusNumberView.show();
    }
}
