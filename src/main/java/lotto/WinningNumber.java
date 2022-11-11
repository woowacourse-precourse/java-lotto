package lotto;

import java.util.ArrayList;
import java.util.List;
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
	}

	private static StringTokenizer splitWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, ",");
		if (splitter.countTokens() != 6) {
			throw new IllegalArgumentException("구분자가 쉼표가 아닙니다.");
		}
		return splitter;
	}

	private static List<Integer> toList(String winningNumber) {
		StringTokenizer splitter = splitWinningNumber(winningNumber);
		List<Integer> numbers = new ArrayList<>();
		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			numbers.add(Integer.parseInt(token));
		}
		return numbers;
	}
}
