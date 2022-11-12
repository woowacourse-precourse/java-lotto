package lotto;

import java.util.List;
import java.util.ArrayList;

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

			String message = "[ERROR] " + Constant.PAYMENT_UNIT.value + "원 단위로 입력해야 합니다.";
			throw new IllegalArgumentException(message);
		}
	}

	public static List<Integer> getWinningNumbers() {

		System.out.println("\n당첨 번호를 입력해 주세요.");
		String[] numbers = Console.readLine().split(",");

		List<Integer> winningNumbers = converToNumber(numbers);

		verifyNumbers(winningNumbers);
		return winningNumbers;
	}

	public static List<Integer> converToNumber(String[] numbers) {

		List<Integer> result = new ArrayList<Integer>(Constant.LOTTO_LENGTH.value);
		
		for (String number : numbers) {
			
			try {
				Integer _number = Integer.valueOf(number);
				result.add(_number);
			}
			
			catch (NumberFormatException e) {
				throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
			}
		}
		
		return result;
	}

	public static void verifyNumbers(List<Integer> numbers) {

		verifyLength(numbers);
		verifyRange(numbers);
		verifyOverlap(numbers);
	}

	public static void verifyLength(List<Integer> numbers) {

		boolean isValid = numbers.size() == Constant.LOTTO_LENGTH.value;
		if (!isValid) {

			String message = "[ERROR] '1,2,3,4,5,6' 형식으로 번호 6개를 입력해야 합니다.";
			throw new IllegalArgumentException(message);
		}
	}

	public static void verifyRange(List<Integer> numbers) {

		for (Integer number : numbers) {

			boolean isValidStartingNumber = number >= Constant.LOTTO_STARTING_NUMBER.value;
			boolean isValidEndingNumber = number <= Constant.LOTTO_ENDING_NUMBER.value;

			if (!isValidStartingNumber || !isValidEndingNumber) {

				String range = Constant.LOTTO_STARTING_NUMBER.value + "부터 " + Constant.LOTTO_ENDING_NUMBER.value;
				String message = "[ERROR] 로또 번호는 " + range + " 사이의 숫자여야 합니다.";
				throw new IllegalArgumentException(message);
			}
		}
	}

	public static void verifyOverlap(List<Integer> numbers) {

		List<Integer> uniqueNumbers = new ArrayList<Integer>(Constant.LOTTO_LENGTH.value);

		for (Integer number : numbers) {

			if (uniqueNumbers.contains(number)) {
				throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자들로 입력해야 합니다.");
			}

			uniqueNumbers.add(number);
		}
	}
}