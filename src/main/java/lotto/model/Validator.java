package lotto.model;

import lotto.Util;

public abstract class Validator {

	public static void isAllDigit(String input){
		for (int i = 0; i < input.length(); i++) {
			if (Util.isNotDigit(input.charAt(i))){
				throw new IllegalArgumentException("It is not all digit");
			}
		}
	}
}
