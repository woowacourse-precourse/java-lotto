package lotto.domain.player;

import lotto.domain.util.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumber {
	private final String winningNumber;

	public WinningNumber(String winningNumberInput) {
		Validator.validateWinningNumber(winningNumberInput);
		this.winningNumber = winningNumberInput;
	}

	public List<Integer> toNumbers() {
		return Pattern.compile(",").splitAsStream(winningNumber)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public static WinningNumber from(String winningNumberInput) {
		return new WinningNumber(winningNumberInput);
	}
}
