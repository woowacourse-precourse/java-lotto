package lotto.service;

import static lotto.util.Constants.*;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumber {
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);

		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			if (!token.matches(ONLY_INTEGER_SERIES)) {
				throw new IllegalArgumentException(ERROR_NUMERIC);
			}

			if (Integer.parseInt(token) == ZERO) {
				throw new IllegalArgumentException(ERROR_ZERO);
			}

			if (Integer.parseInt(token) > MAX_NUMBER) {
				throw new IllegalArgumentException(ERROR_MAX_NUMBER);
			}
		}

		if (hasDuplicatedNum(convertToSet(winningNumber))) {
			throw new IllegalArgumentException(ERROR_DUPLICATE);
		}
	}

	private static StringTokenizer splitWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, DELIMITER);
		if (splitter.countTokens() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(ERROR_NOT_COMMA);
		}
		return splitter;
	}

	public static Set<Integer> convertToSet(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);
		Set<Integer> numbers = new HashSet<>();
		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			numbers.add(Integer.parseInt(token));
		}
		return numbers;
	}

	private static boolean hasDuplicatedNum(Set<Integer> numbers) {
		return numbers.size() != LOTTO_NUMBER_SIZE;
	}
}
