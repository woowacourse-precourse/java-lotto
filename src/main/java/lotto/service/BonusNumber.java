package lotto.service;

import lotto.util.Validator;

public class BonusNumber {
	public static void checkBonusNumber(String input) {
		Validator.validateNumber(input);
		Validator.validateNoZero(input);
		Validator.validateMaxNumber(input);
	}
}
