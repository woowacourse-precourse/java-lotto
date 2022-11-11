package lotto;

import java.util.List;

public class BonusNumber {
	private final String BONUS_NUMBER_BOUNDARY = "[1-45]";
	private final String INVALID_BONUS_NUMBER_BOUNDARY = "[ERROR] 보너스 당첨번호는 1-45사이의 숫자만 가능합니다.";
	private final String OVERLAP_WITH_WINNER_NUMBERS = "[ERROR] 보너스번호와 당첨번호에는 중복이 없어야 합니다.";
	private int number;

	public BonusNumber(String bonusNumber, List<Integer> winnerNumbers) {
		validateBonusNumberBoundary(bonusNumber);
		validateBonusNumberOverlap(bonusNumber, winnerNumbers);
		this.number = Integer.parseInt(bonusNumber);
	}

	private void validateBonusNumberBoundary(String bonusNumber) {
		if (bonusNumber.matches(BONUS_NUMBER_BOUNDARY)) {
			throw new IllegalArgumentException(INVALID_BONUS_NUMBER_BOUNDARY);
		}
	}

	private void validateBonusNumberOverlap(String bonusNumber, List<Integer> winnerNumbers) {
		int convertBonusNumber = Integer.parseInt(bonusNumber);
		if (winnerNumbers.contains(convertBonusNumber)) {
			throw new IllegalArgumentException(OVERLAP_WITH_WINNER_NUMBERS);
		}
	}

	public int getNumber() {
		return this.number;
	}
}
