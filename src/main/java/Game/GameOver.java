package Game;

import OutputView.Output;
import Utills.Calculator;
import Utills.Earning;
import Winning.WinningHistory;
import Winning.WinningNumber;
import lotto.Lotto;

import java.util.List;

public class GameOver {

    public void finish(int purchasedAmount, List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        Earning earning = new Earning();
        WinningHistory winningHistory = new WinningHistory();
        Calculator calculator = new Calculator();
        double earningAmount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            calculator.calculate(purchasedLotto.getLottoNumber(), winningNumber.getWinningLotto(), winningNumber.getBonusNumber());
            earningAmount += earning.calculate(calculator.getSameCmt(), calculator.getBonusCorrect());
            earning.RankCalculate(calculator.getSameCmt(), calculator.getBonusCorrect(), winningHistory);
        }
        winningHistory.print();
        Output.earningRateMsg(earning.rateCalculate(purchasedAmount, earningAmount));
    }
}
