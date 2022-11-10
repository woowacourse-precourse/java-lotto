package lotto.domain;

import lotto.Setup;

import static java.lang.Integer.*;

public class Validation {
	public static boolean isNotANumber(String input){
		return !input.matches("^\\d+$");
	}

	public static boolean isAssignedCurrencyUnit(String input){
		long amount = parseInt(input);
		return amount%Setup.LOTTO_PRICE.getValue() == 0;
	}

	public static boolean isLessThan1000(String input){
		long amount = parseInt(input);
		return amount < Setup.LOTTO_PRICE.getValue();
	}

}


