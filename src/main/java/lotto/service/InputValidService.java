package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.util.ErrorConst;

public class InputValidService {

	public Integer validateBonus(String bonus) {
		checkAnswer(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		validBonusRange(bonusNumber);
		return bonusNumber;
	}

	public List<Integer> validAnswer(String answer) {
		String[] answers = answer.split(",");
		validAnswersSize(answers);
		validAnswers(answers);
		return Arrays.stream(answers).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

	public Integer validateUserMoney(String userMoney) {
		checkAnswer(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		validNumberDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	private void validBonusRange(Integer bonusNumber) {
		if (1 > bonusNumber || 45 < bonusNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_BONUS_RANGE_ERROR);
		}
	}

	private void checkAnswer(String inputNumber) {
		List<Integer> numbers = inputNumber.chars().mapToObj(i -> i - 48).collect(Collectors.toList());
		int count = (int)numbers.stream().filter(i -> 0 > i || 9 < i).count();
		if (count != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	private void validAnswers(String[] answers) {
		for (String input : answers) {
			checkAnswer(input);
		}
	}

	private void validAnswersSize(String[] split) {
		if (split.length != 6) {
			throw new IllegalArgumentException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	private void validNumberDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

}
