package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidUtil {

	public static Integer validateBonus(String bonus) {
		checkAnswer(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		validBonusRange(bonusNumber);
		return bonusNumber;
	}

	public static List<Integer> validAnswer(String answer) {
		String[] answers = answer.split(",");
		validAnswersSize(answers);
		validAnswers(answers);
		return Arrays.stream(answers).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

	public static void validLottoRange(List<Integer> numbers) {
		//범위 1부터 45 까지
		int count = (int)numbers.stream().filter(i -> 1 <= i && i <= 45).count();
		if (count != 6) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_LOTTO_RANGE_ERROR);
		}
	}

	public static void validBonusRange(Integer bonusNumber) {
		if (1 > bonusNumber || 45 < bonusNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_BONUS_RANGE_ERROR);
		}
	}

	public static void checkAnswer(String inputNumber) {
		List<Integer> numbers = inputNumber.chars().mapToObj(i -> i - 48).collect(Collectors.toList());
		int count = (int)numbers.stream().filter(i -> 0 > i || 9 < i).count();
		if (count != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	public static void validAnswers(String[] answers) {
		for (String input : answers) {
			checkAnswer(input);
		}
	}

	public static void validAnswersSize(String[] split) {
		if (split.length != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	public static void validNumbersSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	public static Integer validateUserMoney(String userMoney) {
		checkAnswer(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		validNumberDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	public static void validNumberDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

	public static void validDuplicated(List<Integer> numbers) {
		//중복되지 않는 숫자
		Set<Integer> numbersSet = Set.copyOf(numbers);
		if (numbers.size() != numbersSet.size()) {
			throw new IllegalArgumentException(ErrorConst.DUPLICATED_ERROR);
		}
	}

}
