package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

	public String inputUserMoney() {
		System.out.println(INPUT_USER_MONEY_MESSAGE);
		return Console.readLine();
	}

	public void validCheck(String str) {
		if (notExistInputValue(str) || isFirstLetterZero(str) || isNotNumber(str) || isNotDividedInto1000Units(str)) {
			throw new IllegalArgumentException("[ERROR]구입 금액은 1000으로 나누어 떨어지는 1000원 이상의 숫자여야 합니다.");
		}
	}

	private boolean notExistInputValue(String str) {
		return str.isEmpty();
	}

	private boolean isFirstLetterZero(String str) {
		return str.charAt(0) == '0';
	}

	private boolean isNotNumber(String str) {
		String REGEX = "\\d+";
		return !str.matches(REGEX);
	}

	private boolean isNotDividedInto1000Units (String str) {
		int userNumbers = Integer.parseInt(str);
		return userNumbers % 1000 != 0;
	}
}
