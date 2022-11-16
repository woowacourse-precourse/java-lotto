package lotto.dto.lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (LottoException.isException(numbers)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호가 올바르지 않습니다.");
		}
	}
}
