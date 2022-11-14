package lotto.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.Notice;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class RunController {
	public void start() {
		Output.printNotice(Notice.START.getNoticeMessage());
		int money = getCurrentMoney();

		if (isNotNull(money)) {
			drawLottery(money);
		}
	}
	private int getCurrentMoney() {
		String numbers = Input.numbers();

		try {
			return Integer.parseInt(numbers);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());
			return 0;
		}
	}

	private boolean isNotNull(int value) {
		return value != 0;
	}

	private void drawLottery(int money) {
		User user = new User(money);
		LottoStore seller = buyLottoByMoney(user.getMoney());

		LottoMachine machine = pickThisRoundLotto();

		if (machine != null) {
			user.setPrizeMoney(getRanking(seller , machine));

			user.setRateOfReturn(new LottoService().getRateOfReturn(user.getPrizeMoney(), user.getMoney()));
			Output.printRateOfReturn(user.getRateOfReturn());
		}
	}

	private LottoStore buyLottoByMoney(int quantity) {
		LottoStore seller = new LottoStore(quantity);

		seller.setLotto(publishLottoByQuantity(seller.getQuantity()));

		return seller;
	}

	private int getRanking(LottoStore seller, LottoMachine machine) {
		Map<Rank, Integer> ranking = new LottoService().getWinningRanking(seller.getLotto(), machine.getWinningNumbers(), machine.getBonusNumber());

		ranking.entrySet().stream()
				.sorted(Collections.reverseOrder());
		Output.printRank(ranking);

		return getMoneyByLotto(ranking);
	}
	private int getMoneyByLotto(Map<Rank, Integer> rank) {
		return new LottoService().getPrizeMoney(rank);
	}

	private List<List<Integer>> publishLottoByQuantity(int quantity) {
		Output.printResult(quantity, Notice.PURCHASE.getNoticeMessage());

		List<List<Integer>> lotto = new LottoService().publishLotteries(quantity);

		for (List<Integer> integers : lotto) {
			Output.printPublishLotteries(integers);
		}

		return lotto;
	}

	private LottoMachine pickThisRoundLotto() {
		List<Integer> winningnUmbers = pickWinningNumbers();

		if (winningnUmbers != null) {
			Lotto lotto = new Lotto(winningnUmbers);
			Object bonusNumber = pickBonusNumber();
			if (bonusNumber != null) {
				return new LottoMachine(lotto.getNumbers(), (int)bonusNumber);
			}
		}

		return null;
	}

	private List<Integer> pickWinningNumbers() {
		Output.printNotice(Notice.WINNING_NUMBERS.getNoticeMessage());
		String winningNumbers = Input.numbers();

		try {
			return new LottoService().convertStringToList(winningNumbers);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage() + "숫자만 입력해주세요");

			return null;
		}
	}

	private Object pickBonusNumber() {
		Output.printNotice(Notice.BONUS_NUMBER.getNoticeMessage());
		String bonusNumber = Input.numbers();

		try {
			return Integer.parseInt(bonusNumber);
		} catch (IllegalArgumentException e) {
			Output.printNotice(Notice.ERROR.getNoticeMessage());

			return null;
		}
	}

}
