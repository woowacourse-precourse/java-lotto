package lotto.domain;

import java.util.List;

public class BonusNumber {
	private static final String VALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45의 범위를 가지며, 1개입니다.";
	private static final int MAX_VALUE = 45;
	private static final int MIN_VALUE = 1;
	private final int bonusNumber;

	public BonusNumber(int number, List<Integer> winNumbers) {
		validBonusNumber(number, winNumbers);
		this.bonusNumber = number;
	}

	private void validBonusNumber(int bonusNumber, List<Integer> winNumbers) {
		if (isWrongRangeBonusNumber(bonusNumber) || isDuplicate(bonusNumber, winNumbers)) {
			throw new IllegalArgumentException(VALID_BONUS_NUMBER_ERROR_MESSAGE);
		}
	}

	private boolean isWrongRangeBonusNumber(int bonusNumber) {
		return !(MIN_VALUE <= bonusNumber && bonusNumber <= MAX_VALUE);
	}

	private boolean isDuplicate(int bonusNumber, List<Integer> winNumbers) {
		return winNumbers.contains(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
