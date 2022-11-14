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

	public void match() {
		compare(user, winningLotto);
	}

	private void compare(User user, WinningLotto winningLotto) {
		UserLotto userLotto = user.getUserLottoes();

		for (Lotto l : userLotto.getUserLottoes()) {
			List<Integer> userLottoOne = l.getNumbers();
			List<Integer> winningLottoNumber = winningLotto.getWinningLotto();
			Integer bonusNumber = winningLotto.getBonusNumber();
			calculateCorrectNumbers(userLottoOne, winningLottoNumber, bonusNumber);
		}

		Print.printCorrectness(correctLottoNumber.getCorrectLottoNumber());
		Print.printYield(correctLottoNumber.getCorrectLottoNumber(), user.getLottoCount());
	}

	private void calculateCorrectNumbers(List<Integer> userLottoOne, List<Integer> winningLottoNumber,
		Integer bonusNumber) {
		List<Integer> correctNumbers = correctLottoNumber.getCorrectLottoNumber();
		correctNumbers.set(0, correctNumbers.get(0) + compareCorrect3Number(userLottoOne, winningLottoNumber));
		correctNumbers.set(1, correctNumbers.get(1) + compareCorrect4Number(userLottoOne, winningLottoNumber));
		correctNumbers.set(2, correctNumbers.get(2) + compareCorrect5Number(userLottoOne, winningLottoNumber));
		correctNumbers.set(3, correctNumbers.get(3) +
			compareCorrect6NumberContainBonusNumber(userLottoOne, winningLottoNumber, bonusNumber));
		correctNumbers.set(4, correctNumbers.get(4) + compareCorrect6Number(userLottoOne, winningLottoNumber));
	}

	private Integer compareCorrect3Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
		Integer correctNumbers = 0;
		for (Integer number : userLottoOne) {
			if (winningLottoNumber.contains(number))
				correctNumbers++;
		}

		if (correctNumbers == 3)
			return 1;

		return 0;
	}

	private Integer compareCorrect4Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
		Integer correctNumbers = 0;
		for (Integer number : userLottoOne) {
			if (winningLottoNumber.contains(number))
				correctNumbers++;
		}

		if (correctNumbers == 4)
			return 1;

		return 0;
	}

	private Integer compareCorrect5Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
		Integer correctNumbers = 0;
		for (Integer number : userLottoOne) {
			if (winningLottoNumber.contains(number))
				correctNumbers++;
		}

		if (correctNumbers == 5)
			return 1;

		return 0;
	}

	private Integer compareCorrect6NumberContainBonusNumber(List<Integer> userLottoOne,
		List<Integer> winningLottoNumber,
		Integer bonusNumber) {
		Integer correctNumbers = 0;
		Integer correctBonusNumbers = 0;

		for (Integer number : userLottoOne) {
			if (winningLottoNumber.contains(number))
				correctNumbers++;
		}
		if (winningLottoNumber.contains(bonusNumber))
			correctBonusNumbers++;

		if (correctNumbers == 5 && correctBonusNumbers == 1)
			return 1;

		return 0;

	}

	private Integer compareCorrect6Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
		Integer correctNumbers = 0;
		for (Integer number : userLottoOne) {
			if (winningLottoNumber.contains(number))
				correctNumbers++;
		}

		if (correctNumbers == 6)
			return 1;

		return 0;
	}

}
