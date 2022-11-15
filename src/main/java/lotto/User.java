package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static int getPayment() {

		int payment = 0;
		System.out.println("구입금액을 입력해 주세요.");
		
		try {
			payment = Integer.parseInt(Console.readLine());
			Verification.verifyPaymentUnit(payment);
		}

		catch (NumberFormatException e) {
			Verification.throwException(ErrorMessage.NON_NUMERIC.value);
		}
		
		return payment;
	}
	
	public static List<Integer> getWinningNumbers() {

		System.out.println("\n당첨 번호를 입력해 주세요.");
		String[] inputNumbers = Console.readLine().split(",");

		List<Integer> winningNumbers = transformNumbers(inputNumbers);

		Verification.verifyNumbers(winningNumbers);
		return winningNumbers;
	}

	public static List<Integer> transformNumbers(String[] numbers) {

		List<Integer> winningNumbers = new ArrayList<Integer>(Constant.LOTTO_NUMBERS_LENGTH.value);

		for (String number : numbers) {

			try {
				Integer _number = Integer.valueOf(number);
				winningNumbers.add(_number);
			}

			catch (NumberFormatException e) {
				Verification.throwException(ErrorMessage.NON_NUMERIC.value);
			}
		}
		return winningNumbers;
	}
	
	public static Integer getBonusNumber(List<Integer> winningNumbers) {

		System.out.println("\n보너스 번호를 입력해 주세요.");
		Integer number = 0;

		try {
			number = Integer.valueOf(Console.readLine());
		}

		catch (NumberFormatException e) {
			Verification.throwException(ErrorMessage.NON_NUMERIC.value);
		}

		Verification.verifyNumber(number, winningNumbers);
		return number;
	}
}