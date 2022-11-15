package lotto.validator;

import java.util.List;

import lotto.view.OutputView;

public class LottoValidator {
	private final WinningNumberValidator winningNumberValidator;
	private final BonusNumberValidator bonusNumberValidator;
	private static List<Integer> winningNumbers;

	public LottoValidator() {
		winningNumberValidator = new WinningNumberValidator();
		bonusNumberValidator = new BonusNumberValidator();
	}

	public List<Integer> validateWinningNumbers(String numbers) {
		try {
			winningNumbers = winningNumberValidator.runWinningNumberValidator(numbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return winningNumbers;
	}

	public Integer validateBonusNumber(String bonus) {
		int resultBonus = 0;
		try {
			resultBonus = bonusNumberValidator.runBonusNumberValidator(bonus, winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return resultBonus;
	}
}
