package lotto.Controller;

import lotto.calculation.LottoNumberCalculation;
import lotto.calculation.LottoPurchase;
import lotto.calculation.RateOfReturn;
import lotto.calculation.WinningResult;
import lotto.input.BonusWinningNumber;
import lotto.input.PurchaseAmount;
import lotto.input.WinningNumber;
import lotto.print.Print;

import java.util.List;
import java.util.Map;

public class LottoController {
    PurchaseAmount purchaseAmount = new PurchaseAmount();
    WinningNumber winningNumber = new WinningNumber();
    BonusWinningNumber bonusWinningNumber = new BonusWinningNumber();

    public void lottoStart() {
        int amount = purchaseAmount.putAmount();
        int purchaseCount = LottoPurchase.getPurchaseCount(amount);
        List<List<Integer>> multipleTickets = LottoNumberCalculation.putTicket(purchaseCount);
        Print.sendPurchaseMessage(purchaseCount);
        Print.sendMultipleTicketsGuide(multipleTickets);

        List<Integer> putWinningNumber = winningNumber.putNumber();
        int bonusNumber = bonusWinningNumber.putBonusNum(putWinningNumber);
        Map<String, Integer> statistics = WinningResult
                .calculateStatistics(multipleTickets, putWinningNumber, bonusNumber);
        Print.sendStatisticsMessage(statistics);

        double rateOfReturn = RateOfReturn.calculate(statistics,amount);
        Print.sendRateOfReturnMessage(rateOfReturn);
    }//lottoStart
}// end class
