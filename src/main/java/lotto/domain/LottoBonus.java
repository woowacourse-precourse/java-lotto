package lotto.domain;

import static lotto.utils.ErrorMessage.*;

public class LottoBonus {
	private int bonusNumber;

	public LottoBonus(int bonusNumber) {
		validate(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}

	private static void validate(int bonusNumber) {
		if (!isValidRange(bonusNumber)) {
			throw new IllegalArgumentException(INPUT_VALID_RANGE.getMessage());
		}
	}

	private static boolean isValidRange(int bonusNumber) {
		return bonusNumber >= 1 && bonusNumber <= 45;
	}
}
