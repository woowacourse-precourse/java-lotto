package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.lottoConstant.Constant;
import lotto.lottoConstant.errorMessage.BonusNumberError;
import lotto.lottoConstant.errorMessage.InputMoneyError;
import lotto.lottoConstant.errorMessage.WinningNumberError;

public class InputView {
	private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해주세요";
	private static final String INPUT_WIN_NUMBER_DIVIDE_STRING = ",";

	public static int inputUserMoney() {
		System.out.println(INPUT_USER_MONEY_MESSAGE);
		int money = Constant.ZERO_NUMBER;
		try {
			money = Integer.parseInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(InputMoneyError.INPUT_MONEY_NUMBER_ERROR_MESSAGE);
		}
		return money;
	}

	public static List<Integer> inputWinningNumber() {
		List<Integer> winNumbers = new ArrayList<>();
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		try {
			winNumbers = Arrays.stream(Console.readLine().split(INPUT_WIN_NUMBER_DIVIDE_STRING))
				.map(Integer::parseInt).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			System.out.println(WinningNumberError.INPUT_WIN_NUMBER_ERROR_MESSAGE);
		}
		return winNumbers;
	}

	public static int inputBonusNumber() {
		int bonusNumber = Constant.ZERO_NUMBER;
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		try {
			bonusNumber = Integer.parseInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(BonusNumberError.INPUT_BONUS_NUMBER_ERROR_MESSAGE);
		}
		return bonusNumber;
	}
}
