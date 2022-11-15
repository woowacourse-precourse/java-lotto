package lotto.validator;

import java.util.List;

public class LottoValidator {
	private final WinningNumberValidator winningNumberValidator;
	private final BonusNumberValidator bonusNumberValidator;
	private static List<Integer> winningNumbers;

	public LottoValidator() {
		winningNumberValidator = new WinningNumberValidator();
		bonusNumberValidator = new BonusNumberValidator();
	}

	public List<Integer> validateWinningNumbers(String numbers) {
		winningNumbers = winningNumberValidator.runWinningNumberValidator(numbers);
		return winningNumbers;
	}

	public Integer validateBonusNumber(String bonus) {
		return bonusNumberValidator.runBonusNumberValidator(bonus, winningNumbers);
	}
}
