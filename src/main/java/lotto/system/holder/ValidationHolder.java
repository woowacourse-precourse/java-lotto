package lotto.system.holder;

import java.util.List;

import lotto.system.exception.ValidatorNotFoundException;
import lotto.system.validator.Validator;

public class ValidationHolder {
	public static final String ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE = "이미 초기화된 validators 를 변경할 수 없습니다.";
	private static final ThreadLocal<List<Validator>> validators = new ThreadLocal<>();

	public static void initializeValidators(List<Validator> target) {
		if (validators.get() == null) {
			validators.set(target);
			return;
		}
		throw new IllegalStateException(ILLEGAL_ACCESSING_TO_INITIALIZED_MESSAGE);
	}

	public static void validate(Object target, Class<?> to) {
		validators.get()
			.stream().filter(validator -> validator.supports(target, to))
			.findAny()
			.orElseThrow(ValidatorNotFoundException::new)
			.validate(target);
	}

	public static void clearHolder() {
		validators.remove();
	}
}
