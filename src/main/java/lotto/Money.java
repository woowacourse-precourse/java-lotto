package lotto;

import static lotto.Constants.*;

public class Money {

	public Money() {
	}

	public static void checkMoneyInput(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}

		if (!isUnitOfThousand(input)) {
			throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
		}
	}

	private static boolean isUnitOfThousand(String input) {
		return Integer.parseInt(input) % LOTTO_PRICE == 0;
	}

	public static int calculateMaximumLottoCount(String input) {
		return Integer.parseInt(input) / LOTTO_PRICE;
	}
}
