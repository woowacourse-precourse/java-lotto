package lotto.domain.player;

import lotto.domain.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumber {
	Validator validator = new Validator();

	private static String winningNumber;

	public WinningNumber(String winningNumberInput) {
		validator.validateLottoNumber(winningNumberInput);
		this.winningNumber = winningNumberInput;
	}

	public List<Integer> toConvert() {
		return Pattern.compile(",").splitAsStream(winningNumber)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
