package lotto;

import java.util.List;

public class ExceptionHandler {

	public static void checkInput(List<String> money) {
		for (int i = 0; i < money.size(); i++) {

			if (!isNumeric(money.get(i))) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "숫자만 입력해주세요");
			}

			int num = Integer.parseInt(money.get(i));

			if (num < 0 || num > 45) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() +" 1 ~ 45 사이의 숫자만 입력해 주세요");
			}
		}

	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character :: isDigit);
	}

	public static void checkSpilt(String numbers) {
		for (int i = 1; i < numbers.length(); i += 2) {
			if (numbers.charAt(i) != ',') {
				throw new IllegalArgumentException("[ERROR] 쉼표로 숫자를 구분해 주세요.");
			}
		}
	}

	public static void checkBonus(String bonus) {
		if (bonus.length() < 0 || bonus.length() > 2) {
			throw new IllegalArgumentException("[ERROR] 1개만 입력해 주세요.");
		}

		if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
			throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
		}
	}
}
