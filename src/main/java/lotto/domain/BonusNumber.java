package lotto.domain;

import java.util.List;

public class BonusNumber {

	private final String INVALID_INPUT_LETTER = "[ERROR] 숫자만 입력이 가능합니다.";
	private final String INVALID_BONUS_NUMBER_BOUNDARY = "[ERROR] 보너스번호는 1-45사이의 숫자만 가능합니다.";
	private final String OVERLAP_WITH_WINNER_NUMBERS = "[ERROR] 보너스번호와 당첨번호에는 중복이 없어야 합니다.";
	private final String INVALID_FIRST_NUMBER = "[ERROR] 두자리 숫자인 보너스번호의 첫번째 자리는 0이 올 수 없습니다.";
	private final String CHECK_NUMBER = "\\d{1,2}";
	private final char FIRST_NUMBER_ZERO = '0';
	private final int MIN_NUMBER_BOUNDARY = 1;
	private final int MAX_NUMBER_BOUNDARY = 45;
	private final int DOUBLE_DIGIT_NUMBER = 2;

	private int number;

	public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
		validateInputLetter(bonusNumber);
		validateBonusNumberBoundary(bonusNumber);
		validateFirstNumberZero(bonusNumber);
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
		if (targetNumber < MIN_NUMBER_BOUNDARY || targetNumber > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_BONUS_NUMBER_BOUNDARY);
		}
	}

	private void validateFirstNumberZero(String bonusNumber) {
		if (bonusNumber.length() == DOUBLE_DIGIT_NUMBER && bonusNumber.charAt(0) == FIRST_NUMBER_ZERO) {
			throw new IllegalArgumentException(INVALID_FIRST_NUMBER);
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
