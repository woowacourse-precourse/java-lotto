package lotto.domain;

import java.util.List;
import java.util.Set;

import lotto.controller.dto.WinningNumberDto;
import lotto.domain.dto.LottoWinsCountDto;
import lotto.util.ErrorConst;
import lotto.util.ValidConst;

public class Lotto {
	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		validate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	private void validate(List<Integer> numbers) {
		validNumbersSize(numbers);
		validLottoNumberRange(numbers);
		validDuplicated(numbers);
	}

	public LottoWinsCountDto matchWinningNumber(WinningNumberDto winningNumberDto) {
		int answerCount = countWinnerNumber(winningNumberDto.getWinningNumbers());
		int bonusCount = countBonus(winningNumberDto.getBonusNumber());
		return new LottoWinsCountDto(answerCount, bonusCount);
	}

	private int countWinnerNumber(List<Integer> answers) {
		return (int)lottoNumbers.stream()
			.filter(number -> answers.contains(number))
			.count();
	}

	private int countBonus(Integer bonusNumber) {
		int bonusCount = 0;
		if (lottoNumbers.contains(bonusNumber)) {
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
		int count = (int)numbers.stream()
			.filter(i -> ValidConst.LOTTO_MIN_NUMBER <= i && i <= ValidConst.LOTTO_MAX_NUMBER)
			.count();
		if (count != ValidConst.LOTTO_MAX_SIZE) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_LOTTO_RANGE_ERROR);
		}
	}

	private void validDuplicated(List<Integer> numbers) {
		Set<Integer> numbersSet = Set.copyOf(numbers);
		if (numbers.size() != numbersSet.size()) {
			throw new IllegalArgumentException(ErrorConst.DUPLICATED_ERROR);
		}
	}

	public String toString() {
		return lottoNumbers.toString();
	}

}
