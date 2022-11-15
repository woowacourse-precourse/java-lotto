package lotto.model;

import static lotto.model.LotteryInformation.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;
	/*
	 * 팩토리메소드 패턴으로 작성 (한번 생성한거 계속 사용함으로)
	 * 유효성검사 생성자에서 해주기
	 * */

	public Lotto(List<Integer> numbers, Integer bonusNumber) {
		this.numbers = numbers;
		drawBonusNumber(bonusNumber);
	}

	private void drawBonusNumber(Integer bonusNumber) {
		numbers.add(BONUS_NUMBER_DIGIT.getCode(), bonusNumber);
	}

	public List<Integer> getWinningNumbers() {
		return numbers;
	}

	// TODO: 추가 기능 구현
}
