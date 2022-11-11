package lotto;

public class ExceptionHandler {

	public static void checkInput(String money) {
		boolean isNumeric = money.chars().allMatch(Character::isDigit);

		if (!isNumeric) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
		}

	}

	public static void checkSpilt(String numbers) {
		for (int i = 1; i < numbers.length(); i += 2) {
			if (numbers.charAt(i) != ',') {
				throw new IllegalArgumentException("[ERROR] 쉼표로 숫자를 구분해 주세요.");
			}
		}
		checkInput(numbers);
	}

	public static void checkBonus(String bonus) {
		if (bonus.length() != 1) {
			throw new IllegalArgumentException("[ERROR] 1개만 입력해 주세요.");
		}

		if (bonus.charAt(0) < '1' || bonus.charAt(0) > 45) {
			throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
		}
	}
}
