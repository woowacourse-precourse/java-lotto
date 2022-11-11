package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.assertj.core.internal.Numbers;

public class WinningNumber {
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);

		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			if (!token.matches("[0-9]+")) {
				throw new IllegalArgumentException("알맞은 숫자가 아닙니다.");
			}

			if (Integer.parseInt(token) == 0) {
				throw new IllegalArgumentException("0은 입력할 수 없습니다.");
			}

			if (Integer.parseInt(token) > 45) {
				throw new IllegalArgumentException("45보다 큰 숫자는 입력할 수 없습니다.");
			}
		}

		if (hasDuplicatedNum(convertToSet(winningNumber))) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다.");
		}
	}

	private static StringTokenizer splitWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, ",");
		if (splitter.countTokens() != 6) {
			throw new IllegalArgumentException("구분자가 쉼표가 아닙니다.");
		}
		return splitter;
	}

	private static Set<Integer> convertToSet (String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);
		Set<Integer> numbers = new HashSet<>();
		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			numbers.add(Integer.parseInt(token));
		}
		return numbers;
	}

	private static boolean hasDuplicatedNum(Set<Integer> numbers) {
		return numbers.size() != 6;
	}
}
