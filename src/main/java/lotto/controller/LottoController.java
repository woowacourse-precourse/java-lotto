package lotto.controller;

import static lotto.view.ProgressStatement.*;

import java.util.List;

import lotto.model.LotteryMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final InputView inputView;
	private int money;
	private List<List<Integer>> lotteryTickets;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void playLotto() {
		depositMoney();
		lotteryTickets = publishLotteryTickets(money);
	}

	private void depositMoney() {
		OutputView.printProgress(PURCHASE_AMOUNT);
		money = inputView.inputMoney();
	}

	private List<List<Integer>> publishLotteryTickets(int money) {
		LotteryMachine lotteryMachine = new LotteryMachine(money);
		return lotteryMachine.getLotteryTickets();
	}
}
