package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchasingAmountAndTickets;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatisticsCollector;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	public void control() {
		try {
			PurchasingAmountAndTickets purchasingAmountAndTickets = calculateNumberOfTickets();
			Lotteries lotteries = issueLotteries(purchasingAmountAndTickets.getNumberOfTickets());
			WinningNumbers winningNumbers = receiveWinningNumbers();
			BonusNumber bonusNumber = receiveBonusNumbers(winningNumbers);
			WinningStatisticsCollector winningStatisticsCollector = collectWinningStatistics(lotteries, winningNumbers,
				bonusNumber);
			calculateRateOfProfit(purchasingAmountAndTickets, winningStatisticsCollector);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage();
		}
	}

	// TODO : receive랑 calculate로 나눌 것, numberOfTickets 변수로
	private PurchasingAmountAndTickets calculateNumberOfTickets() {
		PurchasingAmountAndTickets purchasingAmountAndTickets = new PurchasingAmountAndTickets(
			Integer.parseInt(inputView.getPurchasingAmount()));
		int numberOfTickets = purchasingAmountAndTickets.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
		return purchasingAmountAndTickets;
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

	private WinningStatisticsCollector collectWinningStatistics(Lotteries lotteries, WinningNumbers winningNumbers,
		BonusNumber bonusNumber) {
		WinningStatisticsCollector winningStatisticsCollector = new WinningStatisticsCollector(lotteries.getLotteries(),
			winningNumbers,
			bonusNumber);
		outputView.printWinningStatistics(winningStatisticsCollector.getCountsOfWins());
		return winningStatisticsCollector;
	}

	private void calculateRateOfProfit(PurchasingAmountAndTickets purchasingAmountAndTickets,
		WinningStatisticsCollector winningStatisticsCollector) {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		float rateOfProfit = profitCalculator.calculate(purchasingAmountAndTickets.getPurchasingAmount(),
			winningStatisticsCollector.getProfit());
		outputView.printRateOfProfit(rateOfProfit);
	}

}
