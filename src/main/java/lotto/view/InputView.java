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
	private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
	private static final Pattern PATTERN = Pattern.compile("([0-9])+");
	private static final int START_LOTTO_NUMBER = 1;
	private static final int FINISH_LOTTO_NUMBER = 45;
	private static final String ERROR_MESSAGE ="[ERROR] 정수만 입력 가능합니다.";

	public static int inputMoney() {
		System.out.println(BUY_SENTENCE);
		String money = Console.readLine();
		return Integer.parseInt(validateInteger(money));
	}

	private static String validateInteger(String string) {
		if (!string.chars().allMatch(Character::isDigit)) {
			System.out.println("[ERROR] 숫자를 입력해주셔야 합니다.");
			return "1000";
		}
		return string;
	}

	public static List<Integer> inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
		List<Integer> winningNumbers = getWinningNumbers(PATTERN.matcher(Console.readLine()));
		Lotto lotto = new Lotto(winningNumbers);
		for(int number : winningNumbers) {
			validateNumberRange(number);
		}
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
		validateNumberRange(Integer.parseInt(number));
		return Integer.parseInt(number);
	}
	
	private static void validateNumberRange(final int value) {
		if (value < START_LOTTO_NUMBER || FINISH_LOTTO_NUMBER < value) {
			throw new IllegalArgumentException("[ERROR] 유효한 로또 번호 범위는 "
					+ START_LOTTO_NUMBER + "~" + FINISH_LOTTO_NUMBER + "입니다.");
		}
	}
}
