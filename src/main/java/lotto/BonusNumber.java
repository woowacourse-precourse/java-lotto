package lotto;

import static lotto.Constants.*;

import java.util.List;

public class BonusNumber {
	public static void checkBonusNumber(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
		if (input.equals("0")) {
			throw new IllegalArgumentException("0은 입력할 수 없습니다.");
		}
		if (Integer.parseInt(input) > MAX_NUMBER) {
			throw new IllegalArgumentException("45보다 큰 숫자는 입력할 수 없습니다.");
		}
	}

	public static void checkDuplicateBonusNumber(String input, List<Integer> winningNumber) {
		if (winningNumber.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException("당첨번호와 중복되는 숫자입니다.");
		}
	}
}
