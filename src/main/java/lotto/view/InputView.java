package lotto.view;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "구입금액을 입력해 주세요.";

	public String inputUserMoney() {
		System.out.println(INPUT_USER_MONEY_MESSAGE);
		return Console.readLine();
	}

	public String inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		return Console.readLine();
	}

	public void validWinningNumber(String str) {
		if (notExistInputValue(str) || isWrongRangeNumber(str) || isWrongSize(str) || isDuplicateNumber(str) ) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45범위를 가지는 6개의 숫자여야 합니다.");
		}
	}

	private boolean isDuplicateNumber(String str) {
		Set<String> notDuplicateNumbers = Arrays.stream(str.split(",")).collect(Collectors.toSet());
		return notDuplicateNumbers.size() != 6;
	}

	private boolean isWrongRangeNumber(String str) {
		return Arrays.stream(str.split(",")).map(Integer::parseInt).allMatch(num -> 1 <= num && num <= 9);
	}

	private boolean isWrongSize(String str) {
		return str.split(",").length == 6;
	}

	public void validMoney(String str) {
		if (notExistInputValue(str) || isFirstLetterZero(str) || isNotNumber(str) || isNotDividedInto1000Units(str)) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어지는 1000원 이상의 숫자여야 합니다.");
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
