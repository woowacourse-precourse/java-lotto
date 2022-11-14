package lotto.model;

import java.util.Arrays;

public class InputNumListValidator extends InputNumValidator {


	public InputNumListValidator(String input) {
		super(input);
	}

	@Override
	public void isValidate() {
		Arrays.stream(INPUT_VALUE.split(","))
				.forEach(split -> {
					isNull(split);
					isAllDigit(split);
				});
	}
}
