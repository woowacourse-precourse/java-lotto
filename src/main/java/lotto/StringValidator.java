package lotto;

public class StringValidator {

	public void checkIsNumber(String string) {
		if (!string.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
		}
	}

	public void checkIsNumberPositive(String string) {
		int money = Integer.parseInt(string);
		if (money <= 0) {
			throw new IllegalArgumentException("[ERROR] 양의 금액을 입력해야 합니다.");
		}
	}

}
