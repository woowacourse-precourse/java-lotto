package lotto.domain.result;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.WinningNumber;
import lotto.ui.ConsoleOutput;

import static lotto.domain.result.MatchCalculator.*;

public class Result {

	public Result(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTickets lottoTickets) {
		MatchCalculator.findMatch(winningNumber, bonusNumber, lottoTickets);
	}

	public void calculateLottoRank() {
		ConsoleOutput.PrintResultMessage(fiveMatchAndBonusMatch, countingMatches);
	}

	public void calculateTotalProfit(PurchaseAmount purchaseAmount) {
		TotalProfit.countPrize();
		ConsoleOutput.PrintProfitMessage(TotalProfit.computeProfit(purchaseAmount.toMoney()));
	}
}
