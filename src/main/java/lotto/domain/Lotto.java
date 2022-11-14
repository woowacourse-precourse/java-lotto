package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
		List<Integer> lottoNumbers = new ArrayList<>(numbers);
		Collections.sort(lottoNumbers);
		this.numbers = lottoNumbers;
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != Number.SIZE.getValue()) {
			throw new IllegalArgumentException(String.format(Error.SIZE.getMessage(), Number.SIZE.getValue()));
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
		if (nonDuplicateNumbers.size() != Number.SIZE.getValue()) {
			throw new IllegalArgumentException(Error.DUPLICATE.getMessage());
		}
	}

}
