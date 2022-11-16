package lotto.domain.lotto;

import lotto.domain.random.PickNumber;
import lotto.validation.Validation;

import java.math.BigInteger;

//예기치 못한 오류 테스트 커밋
public class BuyLotto {

	private static String USER_MONEY;
	public static void prepare_money(String user_input_value) {
		if (!Validation.money_validation(user_input_value)){
			System.out.println("[ERROR] 1000원 단위의 숫자를 입력하셔야됩니다.");
			return;
		}
		USER_MONEY=user_input_value;
		BigInteger money= new BigInteger(user_input_value);
		buy(money);
	}

	public static void buy(BigInteger money){
		int page_of_lotto = money.divide(BigInteger.valueOf(1000)).intValue();
		PickNumber.pick_number_of_lotto(page_of_lotto);
	}

	public static String USER_MONEY_return(){
		return USER_MONEY;
	}
}