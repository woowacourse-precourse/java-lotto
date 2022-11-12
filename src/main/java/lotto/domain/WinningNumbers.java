package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
	private static final String REGEX = "^[1-9]$|^[1-3][0-9]|^4[0-5]$";
	private static final Pattern numberPattern = Pattern.compile(REGEX);

	private final Lotto lottoNumbers;
	private final int bonusNumber;

	public WinningNumbers(String inputWinningNumbers, String inputBonusNumber) {
		List<Integer> numbers = stringToList(inputWinningNumbers);
		this.lottoNumbers = new Lotto(numbers);

		int bonusNumber = validateREGEX(inputBonusNumber);
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
			throw new IllegalArgumentException(
				String.format(ErrorMessage.NUMBER.getMessage(), Number.MIN.getValue(), Number.MAX.getValue()));
		}
		return Integer.parseInt(userInput);
	}

	private int validateBonus(int number) {
		if (getWinningNumbers().contains(number)) {
			throw new IllegalArgumentException(ErrorMessage.BONUS.getMessage());
		}
		return number;
	}

}
