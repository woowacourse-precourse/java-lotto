package lotto;

import static lotto.Constants.*;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumber {
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);

		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			if (!token.matches(ONLY_INTEGER_SERIES)) {
				throw new IllegalArgumentException("알맞은 숫자가 아닙니다.");
			}

			if (Integer.parseInt(token) == ZERO) {
				throw new IllegalArgumentException("0은 입력할 수 없습니다.");
			}

			if (Integer.parseInt(token) > MAX_NUMBER) {
				throw new IllegalArgumentException("45보다 큰 숫자는 입력할 수 없습니다.");
			}
		}

		if (hasDuplicatedNum(convertToSet(winningNumber))) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다.");
		}
	}

	private static StringTokenizer splitWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, DELIMITER);
		if (splitter.countTokens() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("구분자가 쉼표가 아닙니다.");
		}
		return splitter;
	}

	private static Set<Integer> convertToSet(String winningNumber) {
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
