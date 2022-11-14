package lotto;

import java.util.HashMap;
import java.util.List;

import org.assertj.core.util.Lists;

public class Operation {
	private static Operation uniqueOperation = new Operation();

	private Operation() {
	}

	public static Operation getInstance() {
		return uniqueOperation;
	}

	public void start() {
		int ticketCount = Input.enterMoney();
		Output.printTicketCount(ticketCount);

		List<List<Integer>> lotteryTickets = LotterySeller.sellLottery(ticketCount);
		Output.printLotto(lotteryTickets);

		List<Integer> winningLotto = Lists.newArrayList(Input.enterWinningNumber());
		int bonusNumber = Input.enterBonusNumber();

		WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);
		HashMap<Integer, Integer> result = winningLottoResult.produceResult(lotteryTickets);
		Output.printResult(result);
	}
}
