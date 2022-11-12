package lotto;

import java.util.List;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static int getPayment() {

		int payment;

		System.out.println("구입금액을 입력해 주세요.");
		try {
			payment = Integer.parseInt(Console.readLine());

			checkPaymentUnit(payment);
		}

		catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
		}

		return payment;
	}

	public static void checkPaymentUnit(int payment) {

		boolean isThousandUnits = payment % Constant.PAYMENT_UNIT.value == 0;

		if (!isThousandUnits) {
			throw new IllegalArgumentException("[ERROR] " + Constant.PAYMENT_UNIT.value + "원 단위로 입력해야 합니다.");
		}
	}
	
	public static List<Integer> getWinningNumbers() {
		
		System.out.println("\n당첨 번호를 입력해 주세요.");
		String[] numbers = Console.readLine().split(",");
		
		List<Integer> winningNumbers = new ArrayList<Integer>(Constant.LOTTO_LENGTH.value);
		
		for (String number : numbers) {
			
			Integer _number = Integer.valueOf(number);
			winningNumbers.add(_number);
		}
		
		return winningNumbers;
	}
}