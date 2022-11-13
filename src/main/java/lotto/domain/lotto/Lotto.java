package lotto.domain.lotto;

import lotto.domain.util.Validator;
import lotto.ui.ConsoleOutput;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		Validator.validateLottoNumber(numbers);
		this.numbers = numbers;
		ConsoleOutput.PrintIssuedLotto(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
