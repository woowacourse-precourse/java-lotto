package lotto;

import static lotto.util.Constants.*;

import java.util.EnumMap;
import java.util.List;

import org.assertj.core.util.Lists;

import lotto.domain.LotterySeller;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.service.Lotto;
import lotto.service.Money;
import lotto.util.Rank;
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
		try {
			buyLotto();
			compareLotto();
			calculateEarningRate();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void buyLotto() {
		int ticketCount = Input.enterMoney();
		Output.printTicketCount(ticketCount);
		List<Lotto> lotteryTickets = LotterySeller.sellLottery(ticketCount);
		Output.printLotto(lotteryTickets);
	}

	private void compareLotto() {
		List<Integer> winningLotto = Lists.newArrayList(Input.enterWinningNumber());
		int bonusNumber = Input.enterBonusNumber();
		WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);
		EnumMap<Rank, Integer> result = winningLottoResult.produceResult(LotterySeller.getLotteryTickets());
		Output.printResult(result);
	}

	private void calculateEarningRate() {
		Long earningMoney = Prize.getTotalPrizeMoney(WinningLotto.getPrizeResult());
		Output.printEarningRate(Money.getTicketCount() * LOTTO_PRICE, earningMoney);
	}
}
