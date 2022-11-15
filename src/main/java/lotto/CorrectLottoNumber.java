package lotto;

import java.util.ArrayList;
import java.util.List;

public class CorrectLottoNumber {

	/*
	 * correctLottoNumber는 로또번호와 당첨번호간 같은 갯수를 3,4,5,6(보너스포함),6개 순으로
	 * 당첨 횟수를 저장하는 배열이다.
	 * */
	private final List<Integer> correctLottoNumber;

	public CorrectLottoNumber() {
		this.correctLottoNumber = new ArrayList<>(List.of(0, 0, 0, 0, 0));
	}

	public List<Integer> getCorrectLottoNumber() {
		return correctLottoNumber;
	}

	public void calculateCorrectNumber(List<Integer> userLottoOne, List<Integer> winningLottoNumber,
		Integer bonusNumber){
		correctLottoNumber.set(0, correctLottoNumber.get(0) + compareCorrect3Number(userLottoOne, winningLottoNumber));
		correctLottoNumber.set(1, correctLottoNumber.get(1) + compareCorrect4Number(userLottoOne, winningLottoNumber));
		correctLottoNumber.set(2, correctLottoNumber.get(2) + compareCorrect5Number(userLottoOne, winningLottoNumber));
		correctLottoNumber.set(3, correctLottoNumber.get(3) +
			compareCorrect6NumberContainBonusNumber(userLottoOne, winningLottoNumber, bonusNumber));
		correctLottoNumber.set(4, correctLottoNumber.get(4) + compareCorrect6Number(userLottoOne, winningLottoNumber));
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
		if (userLottoOne.contains(bonusNumber))
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
