package lotto;

public class StringValidator {

	public void validateMoneyString(String string) {
		checkIsNumber(string);
		checkIsPositiveNumber(string);
		checkIsMultipliedBy1000(string);
	}

	public void checkIsNumber(String string) {
		if (!string.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
		}
	}

	public void checkIsPositiveNumber(String string) {
		int money = Integer.parseInt(string);
		if (money <= 0) {
			throw new IllegalArgumentException("[ERROR] 양의 금액을 입력해야 합니다.");
		}
	}

	public void checkIsMultipliedBy1000(String string) {
		int money = Integer.parseInt(string);
		if (money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
		}
	}
}
