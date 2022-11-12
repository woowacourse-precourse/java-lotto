package lotto.domain;

import static lotto.util.ValidUtil.*;

import java.util.List;

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

	public int countAnswer(List<Integer> answers) {
		return (int)numbers.stream()
			.filter(number -> answers.contains(number))
			.count();
	}

	public int countBonus(Integer bonusNumber) {
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
