package lotto.controller;

import static lotto.service.LottoService.*;

import java.util.List;

import lotto.Notice;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.PrizeMoney;
import lotto.domain.User;
import lotto.view.Input;
import lotto.view.Output;

public class RunController {
	public static void getMoney() {
		Output.printNotice(Notice.START.getNoticeMessage());

		int money = checkMoney();

		if (money != 0) {
			User user = new User(money);

			start(user.getMoney());
		}
	}

	private static void start(int money) {
		LottoStore seller = new LottoStore(money);

		seller.setLotto(publishLotteries(seller.getQuantity()));

		Output.printResult(seller.getQuantity(), Notice.PURCHASE.getNoticeMessage());

		LottoMachine machine = getThisRoundLotto();

		List<Integer> prizeMoney = getPrizeMoney(seller.getLotto(), machine.getWinningNumbers(), machine.getBonusNumber());

		User user = new User(money);

		user.setRateOfReturn(calculateProfit(prizeMoney, money));

		Output.printNotice(Notice.STATISTICS.getNoticeMessage());
		Output.printRateOfReturn(user.getRateOfReturn());
	}

	private static LottoMachine getThisRoundLotto() {
		Output.printNotice(Notice.WINNING_NUMBERS.getNoticeMessage());
		Lotto lotto = new Lotto(pickWinningNumbers());

		Output.printNotice(Notice.BONUS_NUMBER.getNoticeMessage());
		LottoMachine machine = new LottoMachine(lotto.getNumbers(), pickBonusNumbers());

		return machine;
	}

	private static List<Integer> getPrizeMoney(List<List<Integer>> candidate, List<Integer> lotto, int bonus) {
		PrizeMoney money = new PrizeMoney();

		money.setCount(getWinningRanking(candidate, lotto, bonus));
		Output.printCount(money.getCount());

		return money.getCount();
	}

	private static int checkMoney() {
		int checkMoney = 0;
		String money = Input.buyLotto();

		try {
			checkMoney = Integer.parseInt(money);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());
		}

		return checkMoney;
	}
}
