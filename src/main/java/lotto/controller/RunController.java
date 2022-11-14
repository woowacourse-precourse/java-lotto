package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.utils.Notice;
import lotto.domain.Rank;
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
			user.setPrizeMoney(getRankingByLotto(seller , machine));

			user.setRateOfReturn(new LottoService().getRateOfReturn(user.getPrizeMoney(), user.getMoney()));
			Output.printRateOfReturn(user.getRateOfReturn());
		}
	}

	private LottoStore buyLottoByMoney(int quantity) {
		LottoStore seller = new LottoStore(quantity);

		seller.setLotto(publishLottoByQuantity(seller.getQuantity()));

		return seller;
	}

	private int getRankingByLotto(LottoStore seller, LottoMachine machine) {
		Map<Rank, Integer> rank = new LottoService().countWinningNumber(seller.getLotto(), machine.getWinningNumbers(), machine.getBonusNumber());

		for (int i = 0; i < Rank.getKeyWithoutDefault().size(); i++) {
			Rank key = Rank.getKeyWithoutDefault().get(i);

			rank.put(key, rank.getOrDefault(key, 0));
		}
		rank.remove(Rank.valueOf("NO_PRIZE"));

		Output.printRank(rank);

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
		List<Integer> winningUmbers = pickWinningNumbers();

		if (winningUmbers != null) {
			Lotto lotto = new Lotto(winningUmbers);
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
