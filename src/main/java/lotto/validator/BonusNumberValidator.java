package lotto.validator;

import static lotto.validator.ErrorMessage.*;

import java.util.List;

public class BonusNumberValidator {

	public Integer runBonusNumberValidator(Integer bonusNumber, List<Integer> winningNumbers) throws
		IllegalArgumentException {
		if (isOutBoundsNumber(bonusNumber)) {
			throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE.getErrorMessage());
		}
		if (isDuplicateWinningNumbers(bonusNumber, winningNumbers)) {
			throw new IllegalArgumentException(NOT_DUPLICATED.getErrorMessage());
		}

		return bonusNumber;
	}

	private boolean isOutBoundsNumber(int bonusNumber) {
		return bonusNumber < 0 || bonusNumber > 45;
	}

	private boolean isDuplicateWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
		return winningNumbers.stream().anyMatch(a -> a.equals(bonusNumber));
	}
}
