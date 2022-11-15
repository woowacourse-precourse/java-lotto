package controller;

import view.OutputView;

import java.util.List;

public class LottoGameController {
    public void run() {
        InputController inputController = new InputController();
        int purchasingMoney = inputController.inputMoney();
        int chanceNumber = RandomNumberCreator.DivideMoneyBy1000(purchasingMoney);
        List<List<Integer>> randomNumbersContainer = RandomNumberCreator.MakeRandomNumber(chanceNumber);
        List<Integer> winningNumber = inputController.inputWinningNumber();
        int bonusNumber = inputController.inputBonusNumber();
        showResult(randomNumbersContainer,winningNumber,bonusNumber);
    }

    private void showResult(List<List<Integer>> randomNumbersContainer, List<Integer> winningNumber, int bonusNumber) {
        OutputView.showWinningStatistics();

    }
}
