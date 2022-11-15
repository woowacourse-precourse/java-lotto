package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.util.ErrorConst;
import lotto.util.ValidConst;

public class InputValidService {

	public Integer validateBonus(String bonus, List<Integer> winningNumber) {
		checkIsNumber(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		validNumberRange(bonusNumber);
		checkWinningNumberAndBonusNumberDuplicated(winningNumber, bonusNumber);
		return bonusNumber;
	}

	public List<Integer> validWinningNumber(String answer) {
		String[] answers = answer.split(",");
		validWinningNumbersSize(answers);
		validWinningNumbers(answers);
		return Arrays.stream(answers).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

	public Integer validateUserMoney(String userMoney) {
		checkIsNumber(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		validNumberDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	private void checkWinningNumberAndBonusNumberDuplicated(List<Integer> winningNumber, Integer bonusNumber) {
		if (winningNumber.contains(bonusNumber)) {
			throw new RuntimeException(ErrorConst.DUPLICATED_ERROR);
		}
	}

	private void validNumberRange(Integer bonusNumber) {
		if (ValidConst.LOTTO_MIN_NUMBER > bonusNumber || ValidConst.LOTTO_MAX_NUMBER < bonusNumber) {
			throw new RuntimeException(ErrorConst.OUT_OF_BONUS_RANGE_ERROR);
		}
	}

	private void checkIsNumber(String inputNumber) {
		List<Integer> numbers = inputNumber.chars().mapToObj(i -> i - 48).collect(Collectors.toList());
		int count = (int)numbers.stream()
			.filter(i -> ValidConst.MIN_NUMBER_PER_CHARACTER > i || ValidConst.MAX_NUMBER_PER_CHARACTER < i)
			.count();
		if (count != 0) {
			throw new RuntimeException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	private void validWinningNumbers(String[] answers) {
		for (String input : answers) {
			checkIsNumber(input);
			Integer bonusNumber = Integer.valueOf(input);
			validNumberRange(bonusNumber);
		}
	}

	private void validWinningNumbersSize(String[] split) {
		if (split.length != ValidConst.LOTTO_MAX_SIZE) {
			throw new RuntimeException(ErrorConst.NUMBERS_SIZE_ERROR);
		}
	}

	private void validNumberDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % ValidConst.MONEY_UNIT != 0) {
			throw new RuntimeException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

}
