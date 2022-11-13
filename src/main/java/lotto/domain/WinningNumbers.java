package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
	private static final Pattern numberPattern = Pattern.compile(Regex.RANGE.getExpression());

	private final Lotto lottoNumbers;
	private final int bonusNumber;

	public WinningNumbers(String inputWinningNumbers, String inputBonusNumber) {
		List<Integer> numbers = stringToList(inputWinningNumbers);
		this.lottoNumbers = new Lotto(numbers);

		validateNumberInRange(inputBonusNumber);
		int bonusNumber = Integer.parseInt(inputBonusNumber);
		validateBonus(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return lottoNumbers.getNumbers();
	}

	public int getBonusNumbers() {
		return bonusNumber;
	}

	private List<Integer> stringToList(String userInput) {
		String[] splitUserInput = userInput.split(Regex.COMMA.getExpression());
		List<Integer> list = new ArrayList<>();

		for (String splitString : splitUserInput) {
			validateNumberInRange(splitString);
			list.add(Integer.parseInt(splitString));
		}
		return list;
	}

	private void validateNumberInRange(String userInput) {
		if (!numberPattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException(
				String.format(Error.NUMBER.getMessage(), Number.MIN.getValue(), Number.MAX.getValue()));
		}
	}

	private void validateBonus(int number) {
		if (getWinningNumbers().contains(number)) {
			throw new IllegalArgumentException(Error.BONUS.getMessage());
		}
	}

}
