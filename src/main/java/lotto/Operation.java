package lotto;

import java.util.HashMap;
import java.util.List;

import org.assertj.core.util.Lists;

import lotto.domain.LotterySeller;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

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

		Long earningMoney = Prize.getTotalPrizeMoney(result);
		Output.printEarningRate(ticketCount * 1000, earningMoney);
	}
}
