package lotto;

import java.math.BigInteger;


public class BuyLotto {


	public static void prepare_money(String user_input_value) throws IllegalArgumentException {
		if (!Validation.money_validation(user_input_value)){
			throw new IllegalArgumentException("[ERROR] 1000원단위의 숫자를 입력해야합니다");
		}
		BigInteger money= new BigInteger(user_input_value);
		buy(money);
	}
	public static void buy(BigInteger money){
		int page_of_lotto = money.divide(BigInteger.valueOf(1000)).intValue();
		PickNumber.pick_number_of_lotto(page_of_lotto);
	}
}