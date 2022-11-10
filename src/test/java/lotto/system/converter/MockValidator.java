package lotto.system.converter;

import lotto.system.validator.Validator;

public class MockValidator implements Validator {
	@Override
	public boolean supports(Object target, Class<?> to) {
		return true;
	}

	@Override
	public void validate(Object target) {

	}
}
