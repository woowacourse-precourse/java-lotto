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
	private List<Lotto> lotteryTickets;
	private Map<Integer, Integer> result;
	// Lotto lotto;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void playLotto() {
		depositMoney();
		publishLotteryTickets(money);

		Lotto winningNumbers = drawWinningNumbers();
		drawBonusNumber(winningNumbers);

		getWinStatistics(winningNumbers);
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

	private Lotto drawWinningNumbers() {
		OutputView.printProgress(WINNING_NUMBER);
		List<Integer> inputWinningNumbers = null;
		try {
			inputWinningNumbers = inputView.inputWinningNumbers();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			// 게임 종료하기
		}
		System.out.println("inputWinningNumbers = " + inputWinningNumbers);
		return new Lotto(inputWinningNumbers);
	}

	private void drawBonusNumber(Lotto winningNumbers) {
		OutputView.printProgress(BONUS_NUMBER);
		Integer bonusNumber = null;
		try {
			bonusNumber = inputView.inputBonusNumber();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		winningNumbers.drawBonusNumber(bonusNumber);
	}

	private void getWinStatistics(Lotto winningNumbers) {
		WinStatisticsCalculator winStatisticsCalculator = new WinStatisticsCalculator(lotteryTickets,
			winningNumbers);
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
