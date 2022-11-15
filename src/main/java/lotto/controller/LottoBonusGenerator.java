package lotto.controller;

import static lotto.utils.ErrorMessage.*;

import lotto.utils.TypeConversion;

public class LottoBonusGenerator {
	public static int generate(String bonusNumber) {
		validate(bonusNumber);
		return TypeConversion.toInt(bonusNumber);
	}

	private static void validate(String bonusNumber) {
		if (!isValidCharacter(bonusNumber)) {
			throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
		}
	}

	private static boolean isValidCharacter(String bonusNumber) {
		return bonusNumber.matches("^[0-9]+$");
	}
}
