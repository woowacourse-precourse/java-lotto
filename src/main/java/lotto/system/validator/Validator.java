package lotto.system.validator;

public interface Validator {
	boolean supports(Object target);

	void validate(Object target);
}
