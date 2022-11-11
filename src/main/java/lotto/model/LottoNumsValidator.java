package lotto.model;

import java.util.Arrays;

public class LottoNumsValidator extends NumberValidator {


	public LottoNumsValidator(String input) {
		super(input);
	}

	@Override
	public void isValidate(){
		Arrays.stream(INPUT_VALUE.split(","))
				.forEach(split -> {
					isNull(split);
					isAllDigit(split);
				});
	}
}
