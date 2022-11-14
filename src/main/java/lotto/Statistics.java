package lotto;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
	private final User user;
	private final WinningLotto winningLotto;
	private final CorrectLottoNumber correctLottoNumber;

	public Statistics(User user, WinningLotto winningLotto) {
		this.user = user;
		this.winningLotto = winningLotto;
		this.correctLottoNumber = new CorrectLottoNumber();
	}

	public void compare() {
		UserLotto userLotto = user.getUserLottoes();

		for (Lotto l : userLotto.getUserLottoes()) {
			List<Integer> userLottoOne = l.getNumbers();
			List<Integer> winningLottoNumber = winningLotto.getWinningLotto();
			Integer bonusNumber = winningLotto.getBonusNumber();
			correctLottoNumber.calculateCorrectNumber(userLottoOne, winningLottoNumber, bonusNumber);
		}

		Print.printCorrectness(correctLottoNumber.getCorrectLottoNumber());
		Print.printYield(correctLottoNumber.getCorrectLottoNumber(), user.getLottoCount());
	}

}
