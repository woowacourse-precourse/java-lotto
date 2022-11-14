package lotto.domain;

import java.util.List;

import lotto.lottoConstant.Constant;
import lotto.lottoConstant.errorMessage.BonusNumberError;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(int number, List<Integer> winNumbers) {
		validBonusNumber(number, winNumbers);
		this.bonusNumber = number;
	}

	private void validBonusNumber(int bonusNumber, List<Integer> winNumbers) {
		if (isWrongRangeBonusNumber(bonusNumber) || isDuplicate(bonusNumber, winNumbers)) {
			throw new IllegalArgumentException(BonusNumberError.VALID_BONUS_NUMBER_ERROR_MESSAGE);
		}
	}

	private boolean isWrongRangeBonusNumber(int bonusNumber) {
		return !(Constant.MIN_VALUE <= bonusNumber && bonusNumber <= Constant.MAX_VALUE);
	}

	private boolean isDuplicate(int bonusNumber, List<Integer> winNumbers) {
		return winNumbers.contains(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
