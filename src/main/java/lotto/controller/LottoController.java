package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void control() {
		try {
			PurchasingAmount purchasingAmount = receivePurchasingAmount();
			int numberOfTickets = calculateNumberOfTickets(purchasingAmount);
			Lotteries lotteries = issueLotteries(numberOfTickets);
			WinningNumbers winningNumbers = receiveWinningNumbers();
			BonusNumber bonusNumber = receiveBonusNumbers(winningNumbers);
			WinningStatistics winningStatistics = collectWinningStatistics(lotteries, winningNumbers, bonusNumber);
			calculateRateOfProfit(purchasingAmount, winningStatistics);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage();
		}
	}

	private PurchasingAmount receivePurchasingAmount() {
		return new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
	}

	private int calculateNumberOfTickets(PurchasingAmount purchasingAmount) {
		int numberOfTickets = purchasingAmount.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
		return numberOfTickets;
	}

	private Lotteries issueLotteries(int numberOfTickets) {
		Lotteries lotteries = new Lotteries(numberOfTickets);
		outputView.printTotalLottoNumbers(lotteries.getTotalLottoNumbers());
		return lotteries;
	}

	private WinningNumbers receiveWinningNumbers() {
		return new WinningNumbers(inputView.getWinningNumbers());
	}

	private BonusNumber receiveBonusNumbers(WinningNumbers winningNumbers) {
		return new BonusNumber(Integer.parseInt(inputView.getBonusNumber()), winningNumbers);
	}

	private WinningStatistics collectWinningStatistics(Lotteries lotteries, WinningNumbers winningNumbers,
		BonusNumber bonusNumber) {
		WinningStatistics winningStatistics = new WinningStatistics(lotteries.getLotteries(), winningNumbers,
			bonusNumber);
		outputView.printWinningStatistics(winningStatistics.getCountsOfWins());
		return winningStatistics;
	}

	private void calculateRateOfProfit(PurchasingAmount purchasingAmount, WinningStatistics winningStatistics) {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		float rateOfProfit = profitCalculator.calculate(purchasingAmount, winningStatistics.getCountsOfWins());
		outputView.printRateOfProfit(rateOfProfit);
	}

}
