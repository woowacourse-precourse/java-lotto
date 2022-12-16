package lotto.domain;

import java.util.Set;

import lotto.exception.Exception;

public class Lotto {
	private final Set<Integer> numbers;
	private static final int NUMBERS_COUNT = 6;
	private static final int INIT = 0;
	private static boolean isMatchBonusNumber;
	private static int countMatchNumber;

	public Lotto(Set<Integer> numbers) {
		validate(numbers);

		this.numbers = numbers;
		this.isMatchBonusNumber = false;
		this.countMatchNumber = INIT;
	}

	private void validate(Set<Integer> numbers) {
		if (numbers.size() != NUMBERS_COUNT) {
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
		this.countMatchNumber = matchNumberCount;
	}

	public boolean getIsMatchBonusNumber() {
		return isMatchBonusNumber;
	}

	public int getCountMatchNumber() {
		return countMatchNumber;
	}
}
