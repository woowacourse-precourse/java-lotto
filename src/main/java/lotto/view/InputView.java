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
	private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";
	private static final String INPUT_MONEY_ERROR_MESSAGE = "구입금액은 숫자여야 합니다.";
	private static final String IN_MONEY_ERROR_MESSAGE = "구입 금액은 1000원 단위로 입력하셔야 합니다.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요";

	public int inputUserMoney() {
		System.out.println(INPUT_USER_MONEY_MESSAGE);
		int money = 0;
		try {
			money = Integer.parseInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(DEFAULT_ERROR_MESSAGE + INPUT_MONEY_ERROR_MESSAGE);
		}
		return money;
	}

	public void validMoney(int money) {
		if (isNotDividedInto1000Units(money)) {
			throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + IN_MONEY_ERROR_MESSAGE);
		}
	}

	private boolean isNotDividedInto1000Units (int money) {
		return money % 1000 != 0;
	}

	public String inputWinningNumber() {
		System.out.println();
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		return Console.readLine();
	}

	public String inputBonusNumber() {
		System.out.println();
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		return Console.readLine();
	}

	public void validBonusNumber(String str) {
		if (isWrongRangeBonusNumber(str)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45의 범위를 가지는 1개의 숫자여야 합니다.");
		}
	}

	private boolean isWrongRangeBonusNumber(String str) {
		int bonusNumber = Integer.parseInt(str);
		return !(1 <= bonusNumber && bonusNumber <= 45);
	}

	public void validWinningNumber(String userInput) {
		if (isWrongSize(userInput) || isDuplicateNumber(userInput)
			|| isWrongRangeWinningNumber(userInput)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45의 범위를 가지는 6개의 숫자여야 합니다.");
		}
	}

	private boolean isDuplicateNumber(String str) {
		Set<String> notDuplicateNumbers = Arrays.stream(str.split(",")).collect(Collectors.toSet());
		return notDuplicateNumbers.size() != 6;
	}

	private boolean isWrongRangeWinningNumber(String str) {
		return Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).noneMatch(num -> 1 <= num && num <= 45);
	}

	private boolean isWrongSize(String str) {
		return str.split(",").length != 6;
	}
}
