package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
	private static final String VALID_WIN_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1~45의 범위를 가지며, 6개입니다.";
	private static final int DEFAULT_SIZE = 6;
	private static final int MAX_VALUE = 45;
	private static final int MIN_VALUE = 1;
	private final List<Integer> winningNumber;

	public WinningNumber(List<Integer> number) {
		this.winningNumber = number;
	}

	public void validWinningNumber() {
		if (isWrongSize(winningNumber) || isDuplicateNumber(winningNumber) || isWrongRangeWinningNumber(winningNumber)) {
			throw new IllegalArgumentException(VALID_WIN_NUMBER_ERROR_MESSAGE);
		}
	}

	private boolean isDuplicateNumber(List<Integer> winNumbers) {
		return new HashSet<>(winNumbers).size() != DEFAULT_SIZE;
	}

	private boolean isWrongRangeWinningNumber(List<Integer> winNumbers) {
		return !winNumbers.stream().allMatch(num -> MIN_VALUE <= num && num <= MAX_VALUE);
	}

	private boolean isWrongSize(List<Integer> winNumbers) {
		return winNumbers.size() != DEFAULT_SIZE;
	}
}
