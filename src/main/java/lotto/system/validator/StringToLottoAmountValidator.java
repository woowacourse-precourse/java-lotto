package lotto.system.validator;

import lotto.vo.LottoAmount;

public class StringToLottoAmountValidator implements Validator {

	public static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수값만 입력해야 합니다.";
	public static final String LOWER_THEN_MIN_VALUE_MESSAGE = "로또를 최소 1장 이상 살 수 있는 금액을 입력해야 합니다.";
	public static final String NOT_DIVIDED_VALUE_MESSAGE = "로또의 금액인 1,000원으로 나누어 떨어지는 금액을 입력해야 합니다.";

	@Override
	public boolean supports(Object target, Class<?> to) {
		return target.getClass() == String.class && to == LottoAmount.class;
	}

	@Override
	public void validate(Object target) {
		Integer targetNumber = isOnlyNaturalNumber((String)target);
		isMoreThan0(targetNumber);
		isDividedIn1000(targetNumber);
	}

	private Integer isOnlyNaturalNumber(String target) {
		try {
			target = target.replace(",", "");
			return Integer.valueOf(target);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
		}
	}

	private void isMoreThan0(Integer target) {
		if (target < 1000) {
			throw new IllegalArgumentException(LOWER_THEN_MIN_VALUE_MESSAGE);
		}
	}

	private void isDividedIn1000(Integer target) {
		if (target % 1000 != 0) {
			throw new IllegalArgumentException(NOT_DIVIDED_VALUE_MESSAGE);
		}
	}
}
