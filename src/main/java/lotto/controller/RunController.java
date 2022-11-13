package lotto.controller;

import static lotto.service.LottoService.*;

import java.util.List;

import lotto.Notice;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.service.LottoService;
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

		if (machine != null) {
			user.setPrizeMoney(getMoneyByLotto(seller , machine));
			Output.printCount(user.getPrizeMoney());

			user.setRateOfReturn(calculateRateOfReturn(user.getPrizeMoney(), user.getMoney()));
			Output.printRateOfReturn(user.getRateOfReturn());
		}
	}

	private static boolean isNotNull(int value) {
		return value != 0;
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
		List<Integer> winningNumbers = pickWinningNumbers();

		if (winningNumbers != null) {
			Object bonusNumber = pickBonusNumber();
			if (bonusNumber != null) {
				return new LottoMachine(winningNumbers, (int)bonusNumber);
			}
		}

		return null;
	}

	private static List<Integer> pickWinningNumbers() {
		Output.printNotice(Notice.WINNING_NUMBERS.getNoticeMessage());
		String winningNumbers = Input.numbers();

		try {
			return convertStringToList(winningNumbers);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage() + "숫자만 입력해주세요");

			return null;
		}
	}

	private static Object pickBonusNumber() {
		Output.printNotice(Notice.BONUS_NUMBER.getNoticeMessage());
		String bonusNumber = Input.numbers();

		try {
			return Integer.parseInt(bonusNumber);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());

			return null;
		}
	}

	private static int getCurrentMoney() {
		String numbers = Input.numbers();

		try {
			return Integer.parseInt(numbers);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());
			return 0;
		}
	}
}
