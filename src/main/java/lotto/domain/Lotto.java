package lotto.domain;

import static lotto.util.ValidUtil.*;

import java.util.List;

import lotto.domain.dto.WinnerCountDto;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validNumbersSize(numbers);
		validLottoRange(numbers);
		validDuplicated(numbers);
	}

	public WinnerCountDto countWinnerCount(WinnerNumber winnerNumber) {
		int answerCount = countAnswer(winnerNumber.getAnswerNumbers());
		int bonusCount = countBonus(winnerNumber.getBonusNumber());
		return new WinnerCountDto(answerCount, bonusCount);
	}

	private int countAnswer(List<Integer> answers) {
		return (int)numbers.stream()
			.filter(number -> answers.contains(number))
			.count();
	}

	private int countBonus(Integer bonusNumber) {
		int bonusCount = 0;
		if (numbers.contains(bonusNumber)) {
			bonusCount++;
		}
		return bonusCount;
	}

	public String toString() {
		return numbers.toString();
	}

}
