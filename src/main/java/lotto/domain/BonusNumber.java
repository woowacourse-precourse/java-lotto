package lotto.domain;

import java.util.List;

public class BonusNumber {
	private final String CHECK_NUMBER = "\\d{1,2}";
	private final String INVALID_INPUT_LETTER = "[ERROR] 숫자만 입력이 가능합니다.";
	private final String INVALID_BONUS_NUMBER_BOUNDARY = "[ERROR] 보너스 당첨번호는 1-45사이의 숫자만 가능합니다.";
	private final String OVERLAP_WITH_WINNER_NUMBERS = "[ERROR] 보너스번호와 당첨번호에는 중복이 없어야 합니다.";
	private int number;

	public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
		validateInputLetter(bonusNumber);
		validateBonusNumberBoundary(bonusNumber);
		validateBonusNumberOverlap(bonusNumber, winningNumbers);
		this.number = Integer.parseInt(bonusNumber);
	}

	private void validateInputLetter(String bonusNumber) {
		if (!bonusNumber.matches(CHECK_NUMBER)) {
			throw new IllegalArgumentException(INVALID_INPUT_LETTER);
		}
	}

	private void validateBonusNumberBoundary(String bonusNumber) {
		int targetNumber = Integer.parseInt(bonusNumber);
		if (targetNumber < 1 || targetNumber > 45) {
			throw new IllegalArgumentException(INVALID_BONUS_NUMBER_BOUNDARY);
		}
	}

	private void validateBonusNumberOverlap(String bonusNumber, List<Integer> winningNumbers) {
		int convertBonusNumber = Integer.parseInt(bonusNumber);
		if (winningNumbers.contains(convertBonusNumber)) {
			throw new IllegalArgumentException(OVERLAP_WITH_WINNER_NUMBERS);
		}
	}

	public int getNumber() {
		return this.number;
	}
}
