package lotto;

import java.util.List;
import java.util.ArrayList;

public class Verification {

	public static void verifyPaymentUnit(int payment) {

		boolean isThousandUnits = payment % Constant.PAYMENT_UNIT.value == 0;

		if (!isThousandUnits) {

			String message = Constant.PAYMENT_UNIT.value + "원 단위로 입력해야 합니다.";
			throwException(ErrorMessage.ERROR.value + message);
		}
	}

	public static void verifyNumbers(List<Integer> winningNumbers) {

		verifyLength(winningNumbers);
		verifyRange(winningNumbers);
		verifyOverlap(winningNumbers);
	}

	public static void verifyLength(List<Integer> winningNumbers) {

		boolean isValid = winningNumbers.size() == Constant.LOTTO_NUMBERS_LENGTH.value;
		if (!isValid) {

			String message = "'1,2,3,4,5,6' 형식으로 번호 6개를 입력해야 합니다.";
			throwException(ErrorMessage.ERROR.value + message);
		}
	}

	public static void verifyRange(List<Integer> numbers) {

		for (Integer number : numbers) {

			boolean isValidStartingNumber = number >= Constant.LOTTO_STARTING_NUMBER.value;
			boolean isValidEndingNumber = number <= Constant.LOTTO_ENDING_NUMBER.value;

			if (!isValidStartingNumber || !isValidEndingNumber) {

				String range = Constant.LOTTO_STARTING_NUMBER.value + "부터 " + Constant.LOTTO_ENDING_NUMBER.value;
				String message = "로또 번호는 " + range + " 사이의 숫자여야 합니다.";
				throwException(ErrorMessage.ERROR.value + message);
			}
		}
	}

	public static void verifyOverlap(List<Integer> winningNumbers) {

		List<Integer> uniqueNumbers = new ArrayList<Integer>(Constant.LOTTO_NUMBERS_LENGTH.value);

		for (Integer number : winningNumbers) {

			if (uniqueNumbers.contains(number)) {

				String message = "중복되지 않는 숫자들로 입력해야 합니다.";
				throwException(ErrorMessage.ERROR.value + message);
			}
			uniqueNumbers.add(number);
		}
	}

	public static void verifyNumber(Integer bonusNumber, List<Integer> winningNumbers) {

		verifyRange(new ArrayList<Integer>(bonusNumber));

		boolean isOverlap = winningNumbers.contains(bonusNumber);
		if (isOverlap) {

			String message = "보너스 번호는 당첨 번호와 다른 숫자를 입력해야 합니다.";
			throwException(ErrorMessage.ERROR.value + message);
		}
	}

	public static void throwException(String message) throws IllegalArgumentException {

		throw new IllegalArgumentException(message);
	}
}
