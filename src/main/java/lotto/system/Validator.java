package lotto.system;

import static lotto.constant.Constants.*;

import java.util.List;

public class Validator {

	public static void isListValidate(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != 6) {
			throw new IllegalArgumentException();
		}
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static void isDuplicate(List<Integer> winNumbers, String inputNumber) {
		if (winNumbers.contains(Integer.parseInt(inputNumber))) {
			throw new IllegalArgumentException();
		}
	}

	public static void isInRange(String inputNumber) {
		int num = Integer.parseInt(inputNumber);
		if (num > 45 || num < 1) {
			throw new IllegalArgumentException(OUT_OF_RANGE);
		}
	}

	public static void isMoneyValidate(int money) {
		if (money % 1000 != 0){
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	private static void isOnlyNumber(String[] tests) {
		for (String test : tests) {
			if (Integer.parseInt(test) > 9 || Integer.parseInt(test) < 1) {
				throw new IllegalArgumentException(INVALID_INPUT);
			}
		}
	}
}