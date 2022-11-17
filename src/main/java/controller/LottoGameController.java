package controller;

import domain.LottoResult;
import domain.WinningStatistics;
import view.OutputView;

import java.util.List;

public class LottoGameController {
    private WinningStatistics winningResult;
    private LottoResult lottoResult;
    private int purchasingMoney;
    public void run() {
        try {
            InputController inputController = new InputController();
            purchasingMoney = inputController.inputMoney();
            int chanceNumber = RandomNumberCreator.DivideMoneyBy1000(purchasingMoney);
            List<List<Integer>> randomNumbersContainer = RandomNumberCreator.MakeRandomNumber(chanceNumber);
            List<Integer> winningNumber = inputController.inputWinningNumber();
            int bonusNumber = inputController.inputBonusNumber();
            showResult(randomNumbersContainer,winningNumber,bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void showResult(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonusNumber) {
        OutputView.showWinningStatistics();
        WinningStatistics winningStatistics = new WinningStatistics(randomNumbersContainer,winningNumber,bonusNumber);
        LottoResult lottoResult = new LottoResult(winningStatistics.getWinningStatistics(randomNumbersContainer,winningNumber,bonusNumber),
                purchasingMoney);
        String winningResult = lottoResult.getWinningResult();
        OutputView.showEndResult(winningResult);
    }
}
