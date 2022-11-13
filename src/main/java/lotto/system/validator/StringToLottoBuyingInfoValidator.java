package lotto.system.validator;

import lotto.vo.LottoBuyingInfo;

public class StringToLottoBuyingInfoValidator implements Validator {

	public static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수값만 입력해야 합니다.";

	@Override
	public boolean supports(Object target, Class<?> to) {
		return target.getClass() == String.class && to == LottoBuyingInfo.class;
	}

	@Override
	public void validate(Object target) {
		isOnlyNaturalNumber((String)target);
	}

	private void isOnlyNaturalNumber(String target) {
		if (!target.matches("^[\\d,]+$")) {
			throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
		}
	}
}
