package lotto.models;

import java.util.List;

import static lotto.constants.Message.*;
import static lotto.constants.Constant.*;

public class Bonus {

	private int number;

	public Bonus(int number, Lotto lotto) {
		validateBonus(number, lotto);
		this.number = number;
	}

	protected void validateBonus(int number, Lotto winningLotto) {
		List<Integer> lottoNumber = winningLotto.getLottoNumber();

		if (lottoNumber.contains(number)) {
			throw new IllegalArgumentException(ERROR_EXISTED_LOTTO_BONUS_NUMBER);
		}

		if (hasInvalidValueRange(number)) {
			throw new IllegalArgumentException(ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE);
		}
	}

	private boolean hasInvalidValueRange(int number) {
		return LOTTO_END_NUMBER < number || number < LOTTO_START_NUMBER;
	}

	public int getNumberValue() {
		return number;
	}
}
