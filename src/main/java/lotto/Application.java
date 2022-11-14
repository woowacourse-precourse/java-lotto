package lotto;

import static lotto.domain.Seller.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {
		final Integer money = readPurchaseAmount();
	}

	private static Integer readPurchaseAmount() {
		System.out.println(SELL_ANNOUNCEMENT);
		try {
			final Integer money = Integer.valueOf(Console.readLine());
			if (isNotUnitsOf1000(money)) {
				throw new IllegalArgumentException(ErrorMessage.isNotUnitsOf1000());
			}
			return money;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

	private static boolean isNotUnitsOf1000(Integer money) {
		return money < LOTTO_PRICE || money % LOTTO_PRICE != 0;
	}

}
