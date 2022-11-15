package lotto;

import java.util.List;

public class Game {
    public static void playGame() {
        LottoMachine lottoMachine = new LottoMachine();
        StatisticManager statisticManager = new StatisticManager();
        InputManager inputManager = new InputManager();
        int playerMoney = inputManager.inputMoney();
        int buyNumber = lottoMachine.calculateBuyNumber(playerMoney);
        lottoMachine.buyLotto(buyNumber);
        List<Integer> winningNumbers = statisticManager.stringListToIntegerList(inputManager.inputWinningNumbers());
        int bonusNumber = statisticManager.stringToInt(inputManager.inputBonusNumber(winningNumbers));
        statisticManager.calculateFinalRank(buyNumber, winningNumbers, bonusNumber);
        statisticManager.calculateYield(playerMoney);
        statisticManager.viewResult();
    }
}
