package lotto.dto.lotto;

import java.util.List;

public class LottoException {

	public static boolean isException(List<Integer> numbers) {
		return isNotValidSize(numbers) || isNotRightNumbers(numbers) || isDuplicated(numbers);
	}

	private static boolean isNotRightNumbers(List<Integer> numbers) {
		return numbers.stream().anyMatch(number -> number < 1 || number > 45);
	}

	private static boolean isNotValidSize(List<Integer> numbers) {
		return numbers.size() != 6;
	}

	private static boolean isDuplicated(List<Integer> numbers) {
		return numbers.stream().distinct().count() != 6;
	}
}
