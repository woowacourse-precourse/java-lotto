package lotto.domain;

import static lotto.utils.ErrorMessage.*;

import java.util.List;

public class LottoBonus {
	private int bonusNumber;

	public LottoBonus(int bonusNumber, List<Integer> numbers) {
		validate(bonusNumber, numbers);
		this.bonusNumber = bonusNumber;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}

	private static void validate(int bonusNumber, List<Integer> numbers) {
		if (!isValidRange(bonusNumber)) {
			throw new IllegalArgumentException(INPUT_VALID_RANGE.getMessage());
		}
		if (isDuplicatedNumber(bonusNumber, numbers)) {
			throw new IllegalArgumentException(INPUT_NOT_DUPLICATED_BONUS.getMessage());
		}
	}

	private static boolean isDuplicatedNumber(int bonusNumber, List<Integer> numbers) {
		return numbers.contains(bonusNumber);
	}

	private static boolean isValidRange(int bonusNumber) {
		return bonusNumber >= 1 && bonusNumber <= 45;
	}
}
