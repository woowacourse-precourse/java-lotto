package lotto.validator;

import static lotto.validator.ErrorMessage.*;

import java.util.List;
import java.util.regex.Pattern;

public class BonusNumberValidator {
	private static final Pattern pattern = Pattern.compile("[0-9]+");

	public Integer runBonusNumberValidator(String bonus, List<Integer> winningNumbers) throws IllegalArgumentException {
		int bonusNumber = Integer.parseInt(bonus);

		if (isNotConsistOneData(bonus)) {
			throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
		}
		if (isOutBoundsNumber(bonusNumber)) {
			throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE.getErrorMessage());
		}
		if (isDuplicateWinningNumbers(bonusNumber, winningNumbers)) {
			throw new IllegalArgumentException(NOT_DUPLICATED.getErrorMessage());
		}

		return bonusNumber;
	}

	private boolean isNotConsistOneData(String bonus) {
		return !pattern.matcher(bonus).matches();
	}

	private boolean isOutBoundsNumber(int bonusNumber) {
		return bonusNumber < 0 || bonusNumber > 45;
	}

	private boolean isDuplicateWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
		return winningNumbers.stream().anyMatch(a -> a.equals(bonusNumber));
	}
}
