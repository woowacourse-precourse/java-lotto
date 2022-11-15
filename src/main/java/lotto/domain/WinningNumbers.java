package lotto.domain;

import java.util.List;

import lotto.util.Converter;
import lotto.util.Validator;

public class WinningNumbers {
	private final List<Integer> winningNumbers;

	public WinningNumbers(String winningNumbers) {
		List<Integer> notYetValidatedWinningNumbers = Converter.convertStringWithCommaToIntegerList(winningNumbers);
		validateWinningNumbers(notYetValidatedWinningNumbers);
		this.winningNumbers = notYetValidatedWinningNumbers;
	}

	private void validateWinningNumbers(List<Integer> winningNumbers) {
		Validator.validateSizeOfNumbers(winningNumbers);
		Validator.validateNoDuplication(winningNumbers);
		winningNumbers.forEach(Validator::validateNumberRange);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}
}
