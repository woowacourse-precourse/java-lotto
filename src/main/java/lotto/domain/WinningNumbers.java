package lotto.domain;

import java.util.List;

import lotto.util.Converter;
import lotto.util.Validator;

public class WinningNumbers {
	List<Integer> winningNumbers;

	public WinningNumbers(String winningNumbers) {
		List<Integer> NotYetValidatedWinningNumbers = Converter.convertStringWithCommaToIntegerList(winningNumbers);
		this.winningNumbers = NotYetValidatedWinningNumbers;
	}
}
