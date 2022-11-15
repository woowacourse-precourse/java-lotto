package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
	private static final Pattern NUMBER_PATTERN = Pattern.compile(Regex.RANGE.getExpression());

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
		return lottoNumbers.getLottoNumbers();
	}

	public int getBonusNumbers() {
		return bonusNumber;
	}

	private List<Integer> stringToList(String userInput) {
		String[] splitUserInput = userInput.split(",");
		List<Integer> list = new ArrayList<>();

		for (String splitString : splitUserInput) {
			validateNumberInRange(splitString);
			list.add(Integer.parseInt(splitString));
		}
		return list;
	}

	private void validateNumberInRange(String userInput) {
		if (!NUMBER_PATTERN.matcher(userInput).matches()) {
			throw new IllegalArgumentException(Error.NUMBER.getMessage());
		}
	}

	private void validateBonus(int number) {
		if (getWinningNumbers().contains(number)) {
			throw new IllegalArgumentException(Error.BONUS.getMessage());
		}
	}

}
