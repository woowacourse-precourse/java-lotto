package lotto.controller;

import lotto.domain.LottoPile;
import lotto.domain.WinningStatistic;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.List;

public class LottoSystem {
    private final InputManager inputManager;
    private final LottoPile lottoPile;
    private final OutputManager outputManager;
    private final WinningStatistic winningStatistic;

    public LottoSystem() {
        inputManager = new InputManager();
        lottoPile = new LottoPile();
        outputManager = new OutputManager();
        winningStatistic = new WinningStatistic();
    }

    public void startProgram() {
        int amount = purchaseLotto();
        List<Integer> winningResult = getWinningResult();
        getRevenue(amount, winningResult);
    }

    private int purchaseLotto() {
        int amount = inputManager.readPurchaseAmount();
        lottoPile.issueLottos(amount);
        outputManager.printLottos(lottoPile);
        return amount;
    }

    private List<Integer> getWinningResult() {
        List<Integer> winningNumber = inputManager.readWinningNumber();
        int bonusNumber = inputManager.readBonusNumber();

        List<Integer> winningResult = winningStatistic.calcWinningResult(lottoPile, winningNumber, bonusNumber);
        outputManager.printWinningResult(winningResult);
        return winningResult;
    }

    private void getRevenue(int amount, List<Integer> winningResult) {
        double revenue = winningStatistic.calcRevenue(winningResult, amount);
        outputManager.printRevenue(revenue);
    }
}
