package lotto;

import java.util.List;

public class StringValidator {

	public void validateMoneyString(String string) {
		checkIsNaturalNumber(string);
		checkIsMultipliedBy1000(string);
	}

	public void checkIsNaturalNumber(String string) {
		if (!string.matches("[0-9]+")) {
			throw new IllegalArgumentException(ErrorMsg.STRING_NOT_NATURAL.getMessage());
		}
	}

	public void checkIsMultipliedBy1000(String string) {
		int money = Integer.parseInt(string);
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMsg.STRING_NOT_MULT_BY_1000.getMessage());
		}
	}

	public void validateCorrectString(String string) {
		checkHasOnlyNumberAndComma(string);
	}

	public void checkHasOnlyNumberAndComma(String string) {
		if (!string.matches("[0-9]+(,[0-9]+)*")) {
			throw new IllegalArgumentException(ErrorMsg.STRING_NOT_NUMBER_AND_COMMA.getMessage());
		}
	}

	public void validateBonusString(String string, Lotto lotto) {
		checkIsNaturalNumber(string);
		checkIsInValidRange(string);
		checkCorrectLottoContainsBonusNumber(string, lotto);
	}

	private void checkIsInValidRange(String string) {
		int bonus = Integer.parseInt(string);
		if (bonus < 1 || bonus > 45) {
			throw new IllegalArgumentException(ErrorMsg.STRING_OUT_OF_RANGE.getMessage());
		}
	}

	private void checkCorrectLottoContainsBonusNumber(String string, Lotto lotto) {
		List<Integer> lottoNumbers = lotto.getLotto();
		if (lottoNumbers.contains(Integer.parseInt(string))) {
			throw new IllegalArgumentException(ErrorMsg.STRING_ALREADY_IN_LOTTO.getMessage());
		}
	}
}
