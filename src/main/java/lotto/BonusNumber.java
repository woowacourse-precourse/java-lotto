package lotto;

import static lotto.Constants.*;

public class BonusNumber {
	public static void checkBonusNumber(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}

		if (input.equals("0")) {
			throw new IllegalArgumentException("0은 입력할 수 없습니다.");
		}
	}
}
