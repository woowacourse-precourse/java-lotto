package lotto;

import java.util.StringTokenizer;

public class WinningNumber {
	public static void checkWinningNumber(String winningNumber) {
		StringTokenizer splitter = new StringTokenizer(winningNumber, ",");
		if (splitter.countTokens() != 6) {
			throw new IllegalArgumentException();
		}
	}
}
