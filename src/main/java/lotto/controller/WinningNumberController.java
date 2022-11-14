package lotto.controller;

import java.util.List;
import lotto.domain.WinningNumber;
import lotto.service.WinningNumberService;
import view.BonusNumberView;
import view.WinningNumbersView;

public class WinningNumberController {

    private final WinningNumberService winningNumberService;

    public WinningNumberController(WinningNumberService winningNumberService) {
        this.winningNumberService = winningNumberService;
    }

    public WinningNumber enterNumbers() {
        List<Integer> numbers = enterWinningNumbers();
        int bonusNumber = enterBonusNumber(numbers);
        return new WinningNumber(numbers, bonusNumber);
    }

    private List<Integer> enterWinningNumbers() {
        WinningNumbersView winningNumbersView = new WinningNumbersView();
        return winningNumbersView.show();
    }

    private int enterBonusNumber(List<Integer> numbers) {
        BonusNumberView bonusNumberView = new BonusNumberView(numbers);
        return bonusNumberView.show();
    }
}
