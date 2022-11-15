package lotto.controller;

import lotto.constant.ErrorLog;
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
			outputView.printErrorLog(ErrorLog.ERROR);
		}
	}

	private PurchasingAmount receivePurchasingAmount() {
		PurchasingAmount purchasingAmount = null;
		try {
			purchasingAmount = new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
		} catch (IllegalArgumentException e) {
			outputView.printErrorLog(ErrorLog.PURCHASING_AMOUNT_ERROR);
			throw new IllegalArgumentException();
		}
		return purchasingAmount;
	}

	private int calculateNumberOfTickets(PurchasingAmount purchasingAmount) {
		int numberOfTickets = purchasingAmount.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
		return numberOfTickets;
	}

	private Lotteries issueLotteries(int numberOfTickets) {
		Lotteries lotteries = null;
		try {
			lotteries = new Lotteries(numberOfTickets);
			outputView.printTotalLottoNumbers(lotteries.getTotalLottoNumbers());
		} catch (IllegalArgumentException e) {
			outputView.printErrorLog(ErrorLog.LOTTO_NUMBER_ERROR);
			throw new IllegalArgumentException();
		}
		return lotteries;
	}

	private WinningNumbers receiveWinningNumbers() {
		WinningNumbers winningNumbers = null;
		try {
			winningNumbers = new WinningNumbers(inputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			outputView.printErrorLog(ErrorLog.WINNING_NUMBERS_ERROR);
			throw new IllegalArgumentException();
		}
		return winningNumbers;
	}

	private BonusNumber receiveBonusNumbers(WinningNumbers winningNumbers) {
		BonusNumber bonusNumber = null;
		try {
			bonusNumber = new BonusNumber(Integer.parseInt(inputView.getBonusNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			outputView.printErrorLog(ErrorLog.BONUS_NUMBER_ERROR);
			throw new IllegalArgumentException();
		}
		return bonusNumber;
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
