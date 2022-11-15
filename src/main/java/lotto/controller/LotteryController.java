package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.service.LotteryDrawService;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LotteryController {
    private static LotteryDrawService lotteryDrawService = new LotteryDrawService();

    public static void draw() throws IllegalArgumentException {
        List<Integer> winningNumbers = InputView.takeWinningNumberInput();
        OutputView.insertLineBreak();
        int bonusNumber = InputView.takeBonusNumberInput();
        OutputView.insertLineBreak();
        WinningNumber winningNumber = lotteryDrawService.createWinningNumber(winningNumbers, bonusNumber);
        lotteryDrawService.updateResult(winningNumber);
    }
}
