package lotto.domain;

import java.util.Set;

import lotto.exception.Exception;

public class Lotto {
	private final Set<Integer> numbers;
	private final int NUMBERS_SIZE = 6;
	private boolean isMatchBonusNumber;
	private int matchNumberCount;

	public Lotto(Set<Integer> numbers) {
		validate(numbers);

		this.numbers = numbers;
		this.isMatchBonusNumber = false;
		this.matchNumberCount = 0;
	}

	private void validate(Set<Integer> numbers) {
		if (numbers.size() != NUMBERS_SIZE) {
			throw Exception.LENGTH_EXCEPTION.getException();
		}
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setMatchBonusNumber(boolean matchBonusNumber) {
		isMatchBonusNumber = matchBonusNumber;
	}

	public void setCountMatchNumber(int matchNumberCount) {
		this.matchNumberCount = matchNumberCount;
	}

	public boolean getIsMatchBonusNumber() {
		return isMatchBonusNumber;
	}

	public int getMatchNumberCount() {
		return matchNumberCount;
	}
}
