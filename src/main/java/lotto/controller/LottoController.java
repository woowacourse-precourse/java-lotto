package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningAndBonusNumbers;
import lotto.domain.WinningStatisticsCompiler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	PurchasingAmount purchasingAmount;
	int numberOfTickets;
	List<Lotto> lotteries;
	WinningAndBonusNumbers winningAndBonusNumbers;
	WinningStatisticsCompiler winningStatisticsCompiler;

	public void control() {
		try {
			calculateNumberOfTickets();
			issueLotteries();
			receiveWinningNumbers();
			receiveBonusNumbers();
			compileWinningStatistics();
			calculateRateOfProfit();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage();
		}
	}

	private void calculateRateOfProfit() {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		float rateOfProfit = profitCalculator.calculate(purchasingAmount.getPurchasingAmount(),
			winningStatisticsCompiler.getProfit());
		outputView.printRateOfProfit(rateOfProfit);
	}

	private void calculateNumberOfTickets() {
		purchasingAmount = new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
		numberOfTickets = purchasingAmount.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
	}

	private void issueLotteries() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		lotteries = new ArrayList<>();
		while (lotteries.size() != numberOfTickets) {
			lotteries.add(new Lotto(lottoGenerator.getNumbers()));
		}
		lotteries.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	private void receiveWinningNumbers() {
		winningAndBonusNumbers = new WinningAndBonusNumbers(inputView.getWinningNumbers());
	}

	private void receiveBonusNumbers() {
		winningAndBonusNumbers = new WinningAndBonusNumbers(Integer.parseInt(inputView.getBonusNumber()));
	}

	private void compileWinningStatistics() {
		winningStatisticsCompiler = new WinningStatisticsCompiler(lotteries, winningAndBonusNumbers);
		outputView.printWinningStatistics(winningStatisticsCompiler.getCountsOfWins());
	}
}
