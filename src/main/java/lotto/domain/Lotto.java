package lotto.domain;

import java.util.List;
import java.util.Set;

import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.dto.WinnerCountDto;
import lotto.util.ErrorConst;

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

	public WinnerCountDto countWinnerNumber(WinnerNumberDto winnerNumberDto) {
		int answerCount = countAnswer(winnerNumberDto.getAnswerNumbers());
		int bonusCount = countBonus(winnerNumberDto.getBonusNumber());
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

	private void validNumbersSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	private void validLottoRange(List<Integer> numbers) {
		//범위 1부터 45 까지
		int count = (int)numbers.stream().filter(i -> 1 <= i && i <= 45).count();
		if (count != 6) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_LOTTO_RANGE_ERROR);
		}
	}

	private void validDuplicated(List<Integer> numbers) {
		//중복되지 않는 숫자
		Set<Integer> numbersSet = Set.copyOf(numbers);
		if (numbers.size() != numbersSet.size()) {
			throw new IllegalArgumentException(ErrorConst.DUPLICATED_ERROR);
		}
	}

	public String toString() {
		return numbers.toString();
	}

}
