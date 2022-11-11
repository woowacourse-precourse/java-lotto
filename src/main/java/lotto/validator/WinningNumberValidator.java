package lotto.validator;

import static lotto.validator.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumberValidator {
	private static final Pattern pattern = Pattern.compile("^([1-9]),([1-9]),([1-9]),([1-9]),([1-9]),([1-9])$");

	public void runWinningNumberValidator(String inputData) {
		List<Integer> winningBalls;
		if (isInvalidInputFormat(inputData)) {
			throw new IllegalArgumentException(COMMA_CLASSIFICATION.getErrorMessage());
		}

		winningBalls = inputNumbersToLottoBalls(inputData);
		if (isDuplicatedNumber(winningBalls)) {
			throw new IllegalArgumentException(NOT_DUPLICATED.getErrorMessage());
		}
		if (isOutBoundsNumber(winningBalls)) {
			throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE.getErrorMessage());
		}
	}

	private boolean isInvalidInputFormat(String inputData) {
		return !pattern.matcher(inputData).matches();
	}

	private boolean isDuplicatedNumber(List<Integer> winningBalls) {
		return winningBalls.size() == winningBalls.stream().distinct().count();
	}

	private boolean isOutBoundsNumber(List<Integer> winningBalls) {
		return winningBalls.stream().allMatch(a -> a > 0 && a < 46);
	}

	//	예비자리 - 문자열 리스트로 만들기
	public List<Integer> inputNumbersToLottoBalls(String numbers) {
		List<String> inputNumbers = Arrays.asList(numbers.split(","));
		return inputNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
}
