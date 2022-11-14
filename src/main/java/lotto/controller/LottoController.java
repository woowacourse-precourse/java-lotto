package lotto.controller;

import static lotto.view.ProgressStatement.*;

import java.util.List;

import lotto.model.LotteryMachine;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final InputView inputView;
	private int money;
	private List<List<Integer>> lotteryTickets;
	private List<Integer> winningNumbers;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void playLotto() {
		depositMoney();
		publishLotteryTickets(money);
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
		List<Integer> winningNumbers = inputView.inputWinningNumbers();

		OutputView.printProgress(BONUS_NUMBER);
		Integer bonusNumber = inputView.inputBonusNumber();
		Lotto lotto = new Lotto(winningNumbers, bonusNumber);
	}
}
