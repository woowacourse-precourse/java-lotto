package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.exception.InputExceptionHandler;

public class WinningLotto extends Lotto {
	private static final String REST_REGEX = ",";

	private int bonusNumber;

	public WinningLotto(List<Integer> numbers) {
		super(numbers);
	}

	public static WinningLotto generateWinningLotto(String numbers) {
		return new WinningLotto(convertNumber(numbers));
	}

	private static List<Integer> convertNumber(String numbers) {
		return Arrays.stream(numbers.split(REST_REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(String bonusNumber) {
		this.bonusNumber = InputExceptionHandler.checkBonusNumberForm(getNumbers(), bonusNumber);
	}
}
