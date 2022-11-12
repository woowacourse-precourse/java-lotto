package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidUtil {

	public static void checkNumber(String inputNumber) {
		List<Integer> numbers = inputNumber.chars().mapToObj(i -> i - 48).collect(Collectors.toList());

		int count = (int)numbers.stream().filter(i -> 0 > i || 9 < i).count();
		if (count != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	public static Integer validateBonus(String bonus) {
		checkNumber(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		checkNumberRange(bonusNumber);
		return bonusNumber;
	}

	public static void checkNumberRange(Integer bonusNumber) {
		if (1 > bonusNumber || 45 < bonusNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_ERROR);
		}
	}

	public static List<Integer> validAnswer(String answer) {
		String[] answers = answer.split(",");
		checkNumbersSize(answers);
		checkNumbers(answers);
		return Arrays.stream(answers).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

	public static void checkNumbers(String[] answers) {
		for (String input : answers) {
			checkNumber(input);
		}
	}

	public static void checkNumbersSize(String[] split) {
		if (split.length != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	public static Integer validateUserMoney(String userMoney) {
		checkNumber(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		checkDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	public static void checkDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

}
