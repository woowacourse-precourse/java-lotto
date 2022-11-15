package lotto.domain;

import java.util.List;

public class BonusNumber extends Number {
	private final String OVERLAP_WITH_WINNER_NUMBERS = "[ERROR] 보너스번호는 당첨번호와 중복없이 입력해 주시기 바랍니다.";
	private int number;

	public BonusNumber(String bonusNumber, List<Integer> winningNumbers) {
		validateInputLetter(bonusNumber);
		validateNumberBoundary(bonusNumber);
		validateFirstNumberZero(bonusNumber);
		validateNumberOverlap(bonusNumber, winningNumbers);
		this.number = Integer.parseInt(bonusNumber);
	}

	private void validateNumberOverlap(String bonusNumber, List<Integer> winningNumbers) {
		int convertBonusNumber = Integer.parseInt(bonusNumber);
		if (winningNumbers.contains(convertBonusNumber)) {
			throw new IllegalArgumentException(OVERLAP_WITH_WINNER_NUMBERS);
		}
	}

	public int getNumber() {
		return this.number;
	}
}
