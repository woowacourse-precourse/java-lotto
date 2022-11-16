package lotto.domain.lotteryserver;

import java.util.Arrays;

public class LotteryServerExceptions {
	public static boolean isNumbersExceptions(String[] numbers) {
		return isNotNumberSet(numbers) || isNotInRangeSet(numbers);
	}

	public static boolean isBonusExceptions(String bonus) {
		return isNotNumber(bonus) || isInRangeNumber(bonus);
	}

	private static boolean isNotNumberSet(String[] numbers) {
		try {
			Arrays.stream(numbers).forEach(Integer::parseInt);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

	private static boolean isNotInRangeSet(String[] numbers) {
		return Arrays.stream(numbers)
			.anyMatch(elem -> Integer.parseInt(elem) < 1 || Integer.parseInt(elem) > 45);
	}

	private static boolean isNotNumber(String bonus) {
		try {
			Integer.parseInt(bonus);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

	private static boolean isInRangeNumber(String bonus) {
		return Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45;
	}
}
