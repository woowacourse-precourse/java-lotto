package lotto;

import java.util.StringTokenizer;

public class WinningNumber {
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, ",");
		if (splitter.countTokens() != 6) {
			throw new IllegalArgumentException("구분자가 쉼표가 아닙니다.");
		}

		while (splitter.hasMoreTokens()) {
			String token = splitter.nextToken();
			if (!token.matches("[0-9]+")) {
				throw new IllegalArgumentException("알맞은 숫자가 아닙니다.");
			}

			if (Integer.parseInt(token) == 0) {
				throw new IllegalArgumentException("0은 입력할 수 없습니다.");
			}
		}
	}
}
