package lotto.domain;

import java.util.List;

import lotto.util.Converter;
import lotto.util.Validator;

public class WinningNumbers {
	List<Integer> winningNumbers;

	public WinningNumbers(String winningNumbers) {
		List<Integer> notYetValidatedWinningNumbers = Converter.convertStringWithCommaToIntegerList(winningNumbers);
		validate(notYetValidatedWinningNumbers);
		this.winningNumbers = notYetValidatedWinningNumbers;
	}

	void validate(List<Integer> notYetValidatedWinningNumbers) {
		Validator.validateSizeOfNumbers(notYetValidatedWinningNumbers);
		Validator.validateNoDuplication(notYetValidatedWinningNumbers);
		Validator.validateNumberRange(notYetValidatedWinningNumbers);
	}
}
