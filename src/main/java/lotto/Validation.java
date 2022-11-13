package lotto;

import java.math.BigInteger;

public class Validation {

	public static boolean money_validation(String validation_param){
		if (validation_param.matches("^[0-9]*$")){
			BigInteger money = new BigInteger(validation_param);
			BigInteger target = BigInteger.valueOf(1000);
			if (money_remainder_result_equal_zero(money,target)){
				return true;
			}
		}
		return false;
	}
	public static boolean money_remainder_result_equal_zero(BigInteger money,BigInteger target){
		if (money.remainder(target).compareTo(BigInteger.valueOf(0))==0){
			return true;
		}
		return false;
	}
}
