package game;

import outputView.Output;
import utills.Earning;
import winning.WinningHistory;
import winning.WinningNumber;
import lotto.Lotto;

import java.util.List;

public class GameOver {

    public void finish(int purchasedAmount, List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        Earning earning = new Earning();
        double earningAmount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            earning.scoreCalculate(purchasedLotto.getLottoNumber(), winningNumber.getWinningLotto(), winningNumber.getBonusNumber());
            earningAmount += earning.priceCalculate();
        }

        Output.printHistory(earning.getWinningHistory());
        Output.earningRateMsg(earning.rateCalculate(purchasedAmount, earningAmount));
    }
}
