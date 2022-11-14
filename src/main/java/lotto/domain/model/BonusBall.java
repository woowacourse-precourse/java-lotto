package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class BonusBall {
	private final int bonusBall;

	public BonusBall(String number) {
		bonusBall = validateInt(number);
		validateRange(bonusBall);
	}

	private void validateRange(int bonusBall) {
		if (bonusBall < 1 || 45 < bonusBall) {
			System.out.println(ErrorMessage.ERROR_WRONG_RANGE.getError_message());
			throw new IllegalArgumentException();
		}
	}

	private int validateInt(String input) {
		int number;

		try {
			number = Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(ErrorMessage.ERROR_NOT_INTEGER.getError_message());
			throw new IllegalArgumentException("정수 값을 입력하세요");
		}
		return number;
	}

	public int getBonusBall() {
		return bonusBall;
	}
}
