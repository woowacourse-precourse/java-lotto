package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> sixLengthRandomUniqueNumbers) {
		validateRange(sixLengthRandomUniqueNumbers);
		validateSize(sixLengthRandomUniqueNumbers);
		validateDuplicate(sixLengthRandomUniqueNumbers);
	}

	private void validateRange(List<Integer> randomNumbers) {
		for (int randomNumber : randomNumbers) {
			if (randomNumber < 1) {
				throw new IllegalArgumentException("[ERROR] 로또 번호에 최소값(1) 보다 작은 값이 있습니다.");
			}
			if (randomNumber > 45) {
				throw new IllegalArgumentException("[ERROR] 로또 번호에 최대값(45) 보다 큰 값이 있습니다.");
			}
		}
	}

	private void validateSize(List<Integer> randomNumbers) {
		if (randomNumbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
		}

	}

	private void validateDuplicate(List<Integer> randomNumbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(randomNumbers);
		if (uniqueNumbers.size() != randomNumbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
		}
	}

	// TODO: 추가 기능 구현
	public List<Integer> getNumbers() {
		return numbers;
	}
}