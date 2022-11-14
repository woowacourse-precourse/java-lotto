package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.service.LotteryDrawService;
import lotto.view.InputView;

import java.util.List;

public class LotteryController {
    static LotteryDrawService lotteryDrawService = new LotteryDrawService();

    public static void draw() {
        List<Integer> winningNumbers = InputView.takeWinningNumberInput();
        int bonusNumber = InputView.takeBonusNumberInput();
        WinningNumber winningNumber = lotteryDrawService.createWinningNumber(winningNumbers, bonusNumber);
        lotteryDrawService.updateResult(winningNumber);
    }
}
