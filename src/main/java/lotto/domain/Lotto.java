package lotto.domain;

import java.util.Set;

public class Lotto {
	private final Set<Integer> numbers;
	public boolean isMatchBonusNumber;
	public int matchNumberCount;

	public Lotto(Set<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
		this.isMatchBonusNumber = false;
		this.matchNumberCount = 0;
	}

	private void validate(Set<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setMatchBonusNumber(boolean matchBonusNumber) {
		isMatchBonusNumber = matchBonusNumber;
	}

	public void setMatchNumberCount(int matchNumberCount) {
		this.matchNumberCount = matchNumberCount;
	}
}
