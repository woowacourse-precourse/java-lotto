package lotto.domain;

import java.util.List;

import lotto.util.Converter;
import lotto.util.Validator;

public class WinningNumbers {
	private static List<Integer> winningNumbers;
	private static int bonusNumber;
	public WinningNumbers(String winningNumbers) {
		List<Integer> notYetValidatedWinningNumbers = Converter.convertStringWithCommaToIntegerList(winningNumbers);
		validateWinningNumbers(notYetValidatedWinningNumbers);
		WinningNumbers.winningNumbers = notYetValidatedWinningNumbers;
	}

	public WinningNumbers(int bonusNumber) {
		WinningNumbers.bonusNumber = bonusNumber;
	}

	void validateWinningNumbers(List<Integer> notYetValidatedWinningNumbers) {
		Validator.validateSizeOfNumbers(notYetValidatedWinningNumbers);
		Validator.validateNoDuplication(notYetValidatedWinningNumbers);
		notYetValidatedWinningNumbers.forEach(Validator::validateNumberRange);
	}

	void validateBonusNumber(int bonusNumber) {
	}
}
