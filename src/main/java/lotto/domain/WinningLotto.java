package lotto.domain;

import static lotto.message.ErrorMessageConstants.*;
import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {

	private final List<Integer> bonusNumbers;

	public WinningLotto(Lotto lotto, List<Integer> bonusNumbers) {
		super(lotto.getNumbers());
		validate(bonusNumbers);
		this.bonusNumbers = bonusNumbers;
	}

	public List<Integer> getBonusNumbers() {
		return bonusNumbers;
	}

	private void validate(List<Integer> bonusNumbers) {
		if (bonusNumbers.size() != BONUS_QUANTITY) {
			throw new IllegalArgumentException(String.format(SIZE_ERROR_MESSAGE_FORMAT, BONUS_QUANTITY));
		}
		if (checkRangeBonusNumbers(bonusNumbers)) {
			throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE_FORMAT, MIN_NUMBER, MAX_NUMBER));
		}
		if (checkDuplicateBonusNumbers(bonusNumbers)) {
			throw new IllegalArgumentException(String.format(DUPLICATION_ERROR_MESSAGE));
		}
	}

	private boolean checkRangeBonusNumbers(List<Integer> bonusNumbers) {
		for (int bonusNumber : bonusNumbers) {
			if (bonusNumber < MIN_NUMBER || MAX_NUMBER < bonusNumber) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDuplicateBonusNumbers(List<Integer> bonusNumbers) {
		List<Integer> duplicateBonusNumbers = new ArrayList<>(super.getNumbers());

		for (int bonusNumber : bonusNumbers) {
			if (duplicateBonusNumbers.contains(bonusNumber)) {
				return true;
			}
			duplicateBonusNumbers.add(bonusNumber);
		}
		return false;
	}
}
