package lotto.domain;

import java.util.List;
import java.util.Set;

import lotto.controller.dto.WinnerNumberDto;
import lotto.domain.dto.WinnerCountDto;
import lotto.util.ErrorConst;
import lotto.util.ValidConst;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validNumbersSize(numbers);
		validLottoNumberRange(numbers);
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
		if (numbers.size() != ValidConst.LOTTO_MAX_SIZE) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	private void validLottoNumberRange(List<Integer> numbers) {
		//범위 1부터 45 까지
		int count = (int)numbers.stream()
			.filter(i -> ValidConst.LOTTO_MIN_NUMBER <= i && i <= ValidConst.LOTTO_MAX_NUMBER)
			.count();
		if (count != ValidConst.LOTTO_MAX_SIZE) {
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
