package lotto.domain.lotto;

import lotto.domain.random.PickNumber;
import lotto.validation.Validation;

import java.math.BigInteger;


public class BuyLotto {


	public static void prepare_money(String user_input_value) {
		if (!Validation.money_validation(user_input_value)){
			System.out.println("[ERROR] 1000원 단위의 숫자를 입력하셔야됩니다.");
			return;
		}
		BigInteger money= new BigInteger(user_input_value);
		buy(money);
	}

	public static void buy(BigInteger money){
		int page_of_lotto = money.divide(BigInteger.valueOf(1000)).intValue();
		PickNumber.pick_number_of_lotto(page_of_lotto);
	}
}