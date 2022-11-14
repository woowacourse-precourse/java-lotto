package lotto.model;

import static lotto.model.LotteryInformation.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers, Integer bonusNumber) {
		this.numbers = numbers;
		drawBonusNumber(bonusNumber);
	}

	private void drawBonusNumber(Integer bonusNumber) {
		numbers.add(BONUS_NUMBER_DIGIT.getCode(), bonusNumber);
	}

	// TODO: 추가 기능 구현
}
