package lotto;

import java.math.BigInteger;

public class Validation {

	public static boolean money_validation(String validation_param){
		BigInteger money = new BigInteger(validation_param);
		BigInteger target = BigInteger.valueOf(1000);
		if (validation_param.matches("^[0-9]*$")
										&&
												money.remainder(target).compareTo(BigInteger.valueOf(0))==0){
			return true;
		}
		return false;
	}




}
