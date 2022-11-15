package lotto.controller;

import static lotto.view.ProgressStatement.*;

import java.util.List;
import java.util.Map;

import lotto.model.LotteryMachine;
import lotto.model.Lotto;
import lotto.model.WinStatisticsCalculator;
import lotto.model.YieldCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final InputView inputView;
	private int money;
	private List<List<Integer>> lotteryTickets;
	private Map<Integer, Integer> result;
	Lotto lotto;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void playLotto() {
		depositMoney();
		publishLotteryTickets(money);
		drawWinningNumbers();
		drawBonusNumber();

		getWinStatistics();
		getYield(result, money);
	}

	private void depositMoney() {
		OutputView.printProgress(PURCHASE_AMOUNT);
		money = inputView.inputMoney();
	}

	private void publishLotteryTickets(int money) {
		LotteryMachine lotteryMachine = new LotteryMachine(money);
		int ticketQuantity = lotteryMachine.getTicketQuantity();
		lotteryTickets = lotteryMachine.getLotteryTickets();

		OutputView.printDetails(ticketQuantity, PURCHASE_DETAILS);
		OutputView.printLotteryTickets(lotteryTickets);
	}

	private void drawWinningNumbers() {
		OutputView.printProgress(WINNING_NUMBER);
		String inputWinningNumbers = inputView.inputNumbers();
		lotto = new Lotto(inputWinningNumbers);
	}

	private void drawBonusNumber() {
		OutputView.printProgress(BONUS_NUMBER);
		String inputBonusNumber = inputView.inputNumbers();
		lotto.drawBonusNumber(inputBonusNumber);
	}

	private void getWinStatistics() {
		WinStatisticsCalculator winStatisticsCalculator = new WinStatisticsCalculator(lotteryTickets,
			lotto.getWinningNumbers());
		winStatisticsCalculator.calculateWinningStatus();
		result = winStatisticsCalculator.getMatchResult();

		OutputView.printProgress(WINNING_STATISTICS);
		WinStatisticsStatus[] winStatisticsStatus = WinStatisticsStatus.values();

		OutputView.printWinStatisticsStatus(winStatisticsStatus, result);
	}

	private void getYield(Map<Integer, Integer> result, int money) {
		YieldCalculator yieldCalculator = new YieldCalculator(result, money);
		double yield = yieldCalculator.getYield();
		OutputView.printYield(yield);
	}
}
