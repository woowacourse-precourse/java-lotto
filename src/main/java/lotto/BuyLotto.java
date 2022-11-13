package lotto;

import java.math.BigInteger;


public class BuyLotto {


	public static void prepare_money(String user_input_value) throws IllegalArgumentException {
		if (!Validation.money_validation(user_input_value)){
			System.out.println("[ERROR] 1000원단위의 숫자를 입력해야합니다");
			throw new IllegalArgumentException("[ERROR] 1000원단위의 숫자를 입력해야합니다");
		}
	}

}