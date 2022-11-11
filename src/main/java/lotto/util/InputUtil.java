package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

	public Integer validateUserMoney(String userMoney) {
		checkNumber(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		isDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	private void isDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

	private void checkNumber(String inputNumber) {
		List<Integer> number = inputNumber.chars().mapToObj(i -> i - 48).collect(Collectors.toList());

		int count = (int)number.stream().filter(i -> 1 > i || i > 9).count();
		if (count > 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	public Integer validateBonus(String bonus) {
		checkNumber(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		checkNumberRange(bonusNumber);
		return bonusNumber;
	}

	private void checkNumberRange(Integer bonusNumber) {
		if (1 > bonusNumber || 45 < bonusNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_ERROR);
		}
	}

	public List<Integer> validAnswer(String answer) {
		String[] answers = answer.split(",");
		checkNumbersSize(answers);
		checkNumbers(answers);
		return Arrays.stream(answers).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

	private void checkNumbers(String[] answers) {
		for (String input : answers) {
			checkNumber(input);
		}
	}

	private void checkNumbersSize(String[] split) {
		if (split.length != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

}
