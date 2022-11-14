package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		reduplicationLotto(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	// TODO: 추가 기능 구현

	public List<Integer> getLotto() {
		return numbers;
	}

	public void reduplicationLotto(List<Integer> numbers) throws IllegalArgumentException {
		List<Integer> newList = numbers.stream().distinct().collect(Collectors.toList());
		if (numbers.size() != newList.size()) {
			throw new IllegalArgumentException(Constants.ERROR_RE_DUPLICATION_LOTTO);
		}
	}

}
