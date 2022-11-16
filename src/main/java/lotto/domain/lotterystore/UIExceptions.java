package lotto.domain.lotterystore;

import java.util.Arrays;
import java.util.stream.Stream;

public class UIExceptions {
	public static void validateMoneyFromBuyer(String money) {
		if (isNotNumber(money) || isNotPositiveNumber(money) || isNotZeroRemainder(money)) {
			throw new IllegalArgumentException(Messages.ERROR_FOR_MONEY);
		}
	}

	public static void validateWinningNumbers(String winningNumbers) {
		String[] separation = winningNumbers.split(",");

		if (isNotValidLength(separation) || isNotAllPositiveNumber(separation)
			|| isNotUniqueNumbers(separation)) {
			throw new IllegalArgumentException(Messages.ERROR_FOR_NUMBER_INPUT);
		}
	}

	public static void validateBonusNumbers(String bonusNumber, String winningPrizeNumbers) {
		if (isNotInRange(bonusNumber) || isNotNumber(bonusNumber) || isNotPositiveNumber(
			bonusNumber) || isInWinningPrizeAlready(bonusNumber, winningPrizeNumbers)) {
			throw new IllegalArgumentException(Messages.ERROR_FOR_BONUS_INPUT);
		}
	}

	private static boolean isNotNumber(String money) {
		// 숫자가 아닌 경우 참값 반환
		try {
			Integer.parseInt(money);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

	private static boolean isNotPositiveNumber(String money) {
		// 양수가 아닌 0이나 음수일 경우 참값 반환
		return Integer.parseInt(money) <= 0;
	}

	private static boolean isNotZeroRemainder(String money) {
		// 천원 단위로 입력이 안되었다면 참값 반환
		return (Integer.parseInt(money) % 1000) != 0;
	}

	private static boolean isInWinningPrizeAlready(String bonusNumber, String winningPrizeNumbers) {
		// 11.16) todo<debug> String으로 contains를 처리하게 되면... 숫자단위로 하는 것이 아니라 글자 단위로 판단한다... ㅠㅠ
		// return winningPrizeNumbers.contains(bonusNumber);
		String[] separation = winningPrizeNumbers.split(",");
		return Arrays.stream(separation).anyMatch(elem -> Integer.parseInt(elem) == Integer.parseInt(bonusNumber));
	}

	private static boolean isNotValidLength(String[] separation) {
		return separation.length != 6;
	}

	private static boolean isNotAllPositiveNumber(String[] separation) {
		String[] numbers;
		Stream<String> eachNumber = Arrays.stream(separation);
		try {
			numbers =
				eachNumber.filter(number -> Integer.parseInt(number) > 0).toArray(String[]::new);
		} catch (IllegalArgumentException e) {
			return true;
		}

		return isNotValidLength(numbers) || isNotRange(numbers);
	}

	private static boolean isNotInRange(String bonusNumber) {
		int bonus;

		try {
			bonus = Integer.parseInt(bonusNumber);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return bonus < 1 || bonus > 45;
	}

	private static boolean isNotUniqueNumbers(String[] separation) {
		Stream<String> eachNumber = Arrays.stream(separation);
		String[] numbers = eachNumber.distinct().toArray(String[]::new);
		return numbers.length != 6;
	}

	private static boolean isNotRange(String[] numbers) {
		return Arrays.stream(numbers)
			.anyMatch(elem -> Integer.parseInt(elem) < 1 || Integer.parseInt(elem) > 45);
	}
}
