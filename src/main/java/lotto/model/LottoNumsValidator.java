package lotto.model;

import java.util.Arrays;

public class LottoNumsValidator extends NumberValidator {
	public static String INPUT_VALUE;

	public LottoNumsValidator(String input) {
		isValidate(input);
		INPUT_VALUE = input;
	}

	private void isValidate(String input){
		Arrays.stream(input.split(","))
				.forEach(split -> {
					isNull(split);
					isAllDigit(split);
				});
	}


}
