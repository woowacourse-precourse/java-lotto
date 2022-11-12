package lotto;

import java.util.List;

public class ExceptionHandler {

	public static void checkInput(List<String> money) {
		if (money.size() != 6) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "쉼표로 구분해 주세요");
		}
		for (String s : money) {

			if (!isNumeric(s)) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "숫자만 입력해주세요");
			}

			int num = Integer.parseInt(s);

			if (num < 0 || num > 45) {
				throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + " 1 ~ 45 사이의 숫자만 입력해 주세요");
			}
		}

	}

	private static boolean isNumeric(String str) {
		return str.chars().allMatch(Character :: isDigit);
	}

	public static void checkBonus(String bonus) {
		if (bonus.length() > 2) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() +"1개만 입력해 주세요.");
		}

		if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "1 ~ 45 사이의 숫자를 입력해 주세요.");
		}
	}
}
