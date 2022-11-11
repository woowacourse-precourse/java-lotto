package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

	public Integer validateUserMoney(String userMoney) {
		isNumber(userMoney);
		Integer userMoneyNumber = Integer.valueOf(userMoney);
		isDividedByThousand(userMoneyNumber);
		return userMoneyNumber;
	}

	private void isDividedByThousand(Integer userMoneyNumber) {
		if (userMoneyNumber % 1000 != 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_DIVIDED_BY_THOUSAND);
		}
	}

	private void isNumber(String userMoney) {
		List<Integer> userMoneyNumber = userMoney.chars()
			.mapToObj(i -> i - 48)
			.collect(Collectors.toList());

		int count = (int)userMoneyNumber.stream().filter(i -> 1 > i || i > 9).count();
		if (count > 0) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

	public Integer validateBonus(String bonus) {
		isNumber(bonus);
		Integer bonusNumber = Integer.valueOf(bonus);
		checkNumberRange(bonusNumber);
		return bonusNumber;
	}

	private void checkNumberRange(Integer bonusNumber) {
		if (1 > bonusNumber || 45 < bonusNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_ERROR);
		}
	}

}
