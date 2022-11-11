package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private static final int LOTTO_NUMBERS_SIZE = 6;
	private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 %d개만 가능합니다.";
	private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호들은 중복될 수 없습니다.";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
		this.numbers = new ArrayList<>(numbers);
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException(String.format(SIZE_ERROR_MESSAGE, LOTTO_NUMBERS_SIZE));
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
		if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
		}
	}

}
