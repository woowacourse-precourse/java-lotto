package lotto.validator;

import static lotto.validator.ErrorMessage.*;

import java.util.List;

public class NumberValidator {

	public void runNumberValidator(List<Integer> winningBalls) throws IllegalArgumentException {
		if (isDuplicatedNumber(winningBalls)) {
			throw new IllegalArgumentException(NOT_DUPLICATED.getErrorMessage());
		}
		if (isOutBoundsNumber(winningBalls)) {
			throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE.getErrorMessage());
		}
	}

	private boolean isDuplicatedNumber(List<Integer> winningBalls) {
		return winningBalls.size() != winningBalls.stream().distinct().count();
	}

	private boolean isOutBoundsNumber(List<Integer> winningBalls) {
		return !winningBalls.stream().allMatch(a -> a > 0 && a < 46);
	}
}
