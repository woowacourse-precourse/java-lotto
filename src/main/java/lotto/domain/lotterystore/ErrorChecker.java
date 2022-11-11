package lotto.domain.lotterystore;

import java.util.Arrays;
import java.util.stream.Stream;

public class ErrorChecker {
	public void validateMoneyFromBuyer(String money) {
		if (isNotNumber(money) || isNotPositiveNumber(money) || isNotZeroRemainder(money)) {
			throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요!\n");
		}
	}

	public void validateWinningNumbers(String winningNumbers) {
		String[] separation = winningNumbers.split(",");

		if (isNotValidLength(separation) || isNotAllPositiveNumber(separation)
			|| isNotUniqueNumbers(separation)) {
			throw new IllegalArgumentException("[ERROR] 올바른 당첨번호를 입력해주세요!\n");
		}
	}

	public void validateBonusNumbers(String bonusNumber) {
		if (isNotOneDigit(bonusNumber) || isNotNumber(bonusNumber) || isNotPositiveNumber(
			bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 올바른 보너스번호를 입력해주세요!\n");
		}
	}

	private boolean isNotValidLength(String[] separation) {
		return separation.length != 6;
	}

	private boolean isNotAllPositiveNumber(String[] separation) {
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

	private boolean isNotUniqueNumbers(String[] separation) {
		Stream<String> eachNumber = Arrays.stream(separation);
		String[] numbers = eachNumber.distinct().toArray(String[]::new);
		return numbers.length != 6;
	}

	private boolean isNotRange(String[] numbers) {
		return Arrays.stream(numbers)
			.anyMatch(elem -> Integer.parseInt(elem) < 1 || Integer.parseInt(elem) > 45);
	}

	private boolean isNotNumber(String money) {
		// 숫자가 아닌 경우 참값 반환
		try {
			Integer.parseInt(money);
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

	private boolean isNotPositiveNumber(String money) {
		// 양수가 아닌 0이나 음수일 경우 참값 반환
		return Integer.parseInt(money) <= 0;
	}

	private boolean isNotZeroRemainder(String money) {
		// 천원 단위로 입력이 안되었다면 참값 반환
		return (Integer.parseInt(money) % 1000) != 0;
	}

	private boolean isNotOneDigit(String bonusNumber) {
		return bonusNumber.length() != 1;
	}
}
