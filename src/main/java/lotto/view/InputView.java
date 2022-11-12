package lotto.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";
	private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_MONEY_ERROR_MESSAGE = "구입금액은 숫자여야 합니다.";
	private static final String VALID_MONEY_ERROR_MESSAGE = "구입 금액은 1000원 단위로 입력하셔야 합니다.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_WIN_NUMBER_ERROR_MESSAGE = "당첨 번호는 ,로 구분된 숫자(1,2,3,4,5,6)여야 합니다.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요";
	private static final String INPUT_BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 숫자여야 합니다.";
	private static final String INPUT_WIN_NUMBER_DIVIDE_STRING = ",";
	private static final int DIVIDE_UNIT = 1000;
	private static final int ZERO_NUMBER = 0;

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
			throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + VALID_MONEY_ERROR_MESSAGE);
		}
	}

	private boolean isNotDividedInto1000Units (int money) {
		return money % DIVIDE_UNIT != ZERO_NUMBER;
	}

	public List<Integer> inputWinningNumber() {
		List<Integer> winNumbers = new ArrayList<>();
		System.out.println();
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		try {
			winNumbers = Arrays.stream(Console.readLine().split(INPUT_WIN_NUMBER_DIVIDE_STRING))
				.map(Integer::parseInt).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			System.out.println(DEFAULT_ERROR_MESSAGE + INPUT_WIN_NUMBER_ERROR_MESSAGE);
		}
		return winNumbers;
	}

	public int inputBonusNumber() {
		int bonusNumber = 0;
		System.out.println();
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		try {
			bonusNumber = Integer.parseInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(DEFAULT_ERROR_MESSAGE + INPUT_BONUS_NUMBER_ERROR_MESSAGE);
		}
		return bonusNumber;
	}
}
