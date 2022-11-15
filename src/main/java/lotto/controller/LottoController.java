package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatisticsCompiler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	PurchasingAmount purchasingAmount;
	int numberOfTickets;
	List<Lotto> lotteries;
	WinningNumbers winningNumbers;
	BonusNumber bonusNumber;
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
		winningNumbers = new WinningNumbers(inputView.getWinningNumbers());
	}

	private void receiveBonusNumbers() {
		bonusNumber = new BonusNumber(Integer.parseInt(inputView.getBonusNumber()), winningNumbers);
	}

	private void compileWinningStatistics() {
		winningStatisticsCompiler = new WinningStatisticsCompiler(lotteries, winningNumbers, bonusNumber);
		outputView.printWinningStatistics(winningStatisticsCompiler.getCountsOfWins());
	}
}
