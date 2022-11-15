package lotto.controller;

import lotto.domain.LottoPile;
import lotto.domain.WinningStatistic;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.List;

public class LottoSystem {
    InputManager inputManager;
    LottoPile lottoPile;

    public LottoSystem() {
    }

    public void startProgram() {
        inputManager = new InputManager();

        int amount = inputManager.readPurchaseAmount();

        lottoPile = new LottoPile();
        lottoPile.issueLottos(amount);

        OutputManager outputManager = new OutputManager();
        outputManager.printLottos(lottoPile);

        List<Integer> winningNumber = inputManager.readWinningNumber();
        int bonusNumber = inputManager.readBonusNumber();

        WinningStatistic winningStatistic = new WinningStatistic();

        List<Integer> winningResult = winningStatistic.calcWinningResult(lottoPile, winningNumber, bonusNumber);
        outputManager.printWinningResult(winningResult);

        double revenue = winningStatistic.calcRevenue(winningResult, amount);
        outputManager.printRevenue(revenue);

        return;
    }
}
