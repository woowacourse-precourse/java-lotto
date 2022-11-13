package lotto.domain;

import java.util.List;

import lotto.util.Converter;
import lotto.util.Validator;

public class WinningAndBonusNumbers {
	private static List<Integer> winningNumbers;
	private static int bonusNumber;
	public WinningAndBonusNumbers(String winningNumbers) {
		List<Integer> notYetValidatedWinningNumbers = Converter.convertStringWithCommaToIntegerList(winningNumbers);
		validateWinningNumbers(notYetValidatedWinningNumbers);
		WinningAndBonusNumbers.winningNumbers = notYetValidatedWinningNumbers;
	}

	public WinningAndBonusNumbers(int bonusNumber) {
		validateBonusNumber(bonusNumber);
		WinningAndBonusNumbers.bonusNumber = bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
	void validateWinningNumbers(List<Integer> winningNumbers) {
		Validator.validateSizeOfNumbers(winningNumbers);
		Validator.validateNoDuplication(winningNumbers);
		winningNumbers.forEach(Validator::validateNumberRange);
	}

	void validateBonusNumber(int bonusNumber) {
		Validator.validateNumberRange(bonusNumber);
		Validator.validateExclusion(bonusNumber, winningNumbers);
	}
}
