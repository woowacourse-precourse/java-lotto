package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
public class LottoGameController {
    static int purchaseAmount;
    static int purchaseNumber;
    static List<Lotto> lottos;
    static List<Integer> winNumber;
    static int bonusNumber;
    static int[] winningStats;
    static double rateOfReturn;

    public static void startGame(){
        purchaseAmount = UserController.getPurchaseAmount();
        purchaseNumber = UserController.getPurchaseNumber(purchaseAmount);
        lottos = LottoMachineController.operateLottoMachine(purchaseNumber);
        winNumber = UserController.getWinNumber();
        bonusNumber = UserController.getBonusNumber(winNumber);
    }

}