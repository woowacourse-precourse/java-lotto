package lotto.system.validator;

public interface Validator {
	boolean supports(Object target, Class<?> to);

	void validate(Object target);
}
