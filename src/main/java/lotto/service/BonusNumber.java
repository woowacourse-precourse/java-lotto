package lotto.service;

import java.util.List;
import java.util.Set;

import lotto.util.Validator;

public class BonusNumber {
	public static void checkBonusNumber(String input, Set<Integer> winningNumber) {
		checkBonusNumber(input);
		Validator.validateDuplicateBonusNumber(input, winningNumber);
	}

	public static void checkBonusNumber(String input) {
		Validator.validateNumber(input);
		Validator.validateNoZero(input);
		Validator.validateMaxNumber(input);
	}
}
