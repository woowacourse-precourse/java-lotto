package lotto.service;

import static lotto.util.Constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import lotto.util.Validator;

public class WinningNumber {
	private static Set<Integer> winningNumber;
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);

		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			Validator.validateNumber(token);
			Validator.validateNoZero(token);
			Validator.validateMaxNumber(token);
		}
		Validator.validateDuplicate(winningNumber);
	}

	private static StringTokenizer splitWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, DELIMITER);
		Validator.validateInputWinningNumber(splitter);
		return splitter;
	}

	public static Set<Integer> convertToSet(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);
		Set<Integer> numbers = new HashSet<>();
		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			numbers.add(Integer.parseInt(token));
		}
		setWinningNumber(numbers);
		return numbers;
	}

	public static void setWinningNumber(Set<Integer> winningNumber) {
		WinningNumber.winningNumber = winningNumber;
	}

	public static Set<Integer> getWinningNumber() {
		return winningNumber;
	}
}
