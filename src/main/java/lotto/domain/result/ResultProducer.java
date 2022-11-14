package lotto.domain.result;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.WinningNumber;
import lotto.ui.ConsoleOutput;

public class ResultProducer {

	public void showResultRank(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTickets lottoTickets) {
		MatchCalculator.findMatch(winningNumber, bonusNumber, lottoTickets);
		ConsoleOutput.PrintResultMessage(TotalRank.publishResultSummary().toString());
	}

	public void showResultProfit(PurchaseAmount purchaseAmount) {
		RewardCalculator.calculateTotalReward();
		ConsoleOutput.PrintProfitMessage(TotalProfit.yieldBy(purchaseAmount.toMoney()).toString());
	}
}
