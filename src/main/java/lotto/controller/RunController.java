package lotto.controller;

import static lotto.service.LottoService.*;

import java.util.List;

import lotto.Notice;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.view.Input;
import lotto.view.Output;

public class RunController {
	public static void start() {
		Output.printNotice(Notice.START.getNoticeMessage());
		int money = getCurrentMoney();

		if (isNotNull(money)) {
			drawLottery(money);
		}
	}

	private static void drawLottery(int money) {
		User user = new User(money);
		LottoStore seller = buyLottoByMoney(user.getMoney());

		LottoMachine machine = pickThisRoundLotto();

		user.setPrizeMoney(getMoneyByLotto(seller , machine));
		Output.printCount(user.getPrizeMoney());

		user.setRateOfReturn(calculateRateOfReturn(user.getPrizeMoney(), user.getMoney()));
		Output.printRateOfReturn(user.getRateOfReturn());
	}

	private static boolean isNotNull(int money) {
		return money != 0;
	}

	private static String calculateRateOfReturn(List<Integer> prizeMoney, int money) {
		return calculate(prizeMoney, money);
	}

	private static LottoStore buyLottoByMoney(int quantity) {
		LottoStore seller = new LottoStore(quantity);

		seller.setLotto(publishLottoByQuantity(seller.getQuantity()));

		return seller;
	}

	private static List<Integer> getMoneyByLotto(LottoStore seller, LottoMachine machine) {
		return getWinningRanking(seller.getLotto(), machine.getWinningNumbers(), machine.getBonusNumber());
	}

	private static List<List<Integer>> publishLottoByQuantity(int quantity) {
		Output.printResult(quantity, Notice.PURCHASE.getNoticeMessage());

		List<List<Integer>> lotto = publishLotteries(quantity);

		for (List<Integer> integers : lotto) {
			Output.printPublishLotteries(integers);
		}

		return lotto;
	}

	private static LottoMachine pickThisRoundLotto() {
		Output.printNotice(Notice.WINNING_NUMBERS.getNoticeMessage());
		String winningNumbers = Input.numbers();

		Lotto lotto = new Lotto(pickWinningNumbers(winningNumbers));

		Output.printNotice(Notice.BONUS_NUMBER.getNoticeMessage());
		String bonusNumber = Input.numbers();

		return new LottoMachine(lotto.getNumbers(), pickBonusNumbers(bonusNumber));
	}

	private static int getCurrentMoney() {
		int money = 0;
		String numbers = Input.numbers();

		try {
			money = Integer.parseInt(numbers);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());
		}

		return money;
	}
}
