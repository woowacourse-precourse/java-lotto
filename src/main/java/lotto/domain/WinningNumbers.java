package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbers {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final String REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}|^4{1}[0-5]{1}$";

	private static final Pattern numberPattern = Pattern.compile(REGEX);
	private static final String REGEX_ERROR_MESSAGE = "[ERROR] %d ~ %d 사이의 자연수만 입력해주세요.";
	private static final String BONUS_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

	private final Lotto lottoNumbers;
	private final int bonusNumber;

	public WinningNumbers() {
		String inputWinningNumbers = Console.readLine();
		List<Integer> numbers = stringToList(inputWinningNumbers);
		this.lottoNumbers = new Lotto(numbers);

		String inputBonus = Console.readLine();
		int bonusNumber = validateREGEX(inputBonus);
		this.bonusNumber = validateBonus(bonusNumber);
	}

	public WinningNumbers(String testInput1, String testInput2) {
		List<Integer> numbers = stringToList(testInput1);
		this.lottoNumbers = new Lotto(numbers);
		int bonusNumber = validateREGEX(testInput2);
		this.bonusNumber = validateBonus(bonusNumber);
	}

	public List<Integer> getWinningNumbers() {
		return lottoNumbers.getNumbers();
	}

	public int getBonusNumbers() {
		return bonusNumber;
	}

	private List<Integer> stringToList(String userInput) {
		String[] splitUserInput = userInput.split(",");
		List<Integer> list = new ArrayList<>();

		for (String splitString : splitUserInput) {
			int number = validateREGEX(splitString);
			list.add(number);
		}
		return list;
	}

	private int validateREGEX(String userInput) {
		if (!numberPattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException(String.format(REGEX_ERROR_MESSAGE, MIN_NUMBER, MAX_NUMBER));
		}
		return Integer.parseInt(userInput);
	}

	private int validateBonus(int number) {
		if (getWinningNumbers().contains(number)) {
			throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
		}
		return number;
	}

}
