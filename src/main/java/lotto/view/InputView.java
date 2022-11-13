package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class InputView {

	private static final String BUY_SENTENCE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 볼을 입력해 주세요.";
	private static final Pattern PATTERN = Pattern.compile("([0-9])+");

	public static int inputMoney() {
		System.out.println(BUY_SENTENCE);
		String money = Console.readLine();
		validateInteger(money);
		return Integer.parseInt(money);
	}

	private static void validateInteger(String string) {
		if (!string.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
		}
	}
	
	public static List<Integer> inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
		List<Integer> winningNumbers = getWinningNumbers(PATTERN.matcher(Console.readLine()));
		Lotto lotto = new Lotto(winningNumbers);
		return winningNumbers;
	}

	private static List<Integer> getWinningNumbers(Matcher matcher) {
		List<Integer> winningNumbers = new ArrayList<Integer>();
		while (matcher.find()) {
			String number = matcher.group();
			validateInteger(number);
			winningNumbers.add(Integer.parseInt(number));
		}
		return winningNumbers;
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_SENTENCE);
		String number = Console.readLine();
		validateInteger(number);
		return Integer.parseInt(number);
	}
}
