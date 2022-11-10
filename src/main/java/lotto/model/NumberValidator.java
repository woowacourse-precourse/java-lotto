package lotto.model;

import lotto.Util;

public class NumberValidator {

	public void isAllDigit(String input){
		for (int i = 0; i < input.length(); i++) {
			if (Util.isNotDigit(input.charAt(i))){
				throw new IllegalArgumentException("It is not all digit");
			}
		}
	}

	public void isNull(String input){
		if (input.isBlank()){
			throw new IllegalArgumentException("It is blank");
		}
	}
}
