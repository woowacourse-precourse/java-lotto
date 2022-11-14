package lotto.domain;

import java.util.List;

import lotto.ErrorMessage;

public class Seller {

	private static final int LOTTO_PRICE = 1_000;
	private static final String PURCHASE_ANNOUNCEMENT = "%s개를 구매했습니다.";

	public static List<Lotto> sellLottoTickets(int money) {
		validate(money);
		System.out.println(String.format(PURCHASE_ANNOUNCEMENT, money / LOTTO_PRICE));
		return Lotto.newInstances(money / LOTTO_PRICE);
	}

	private static void validate(Integer money) {
		if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorMessage.isNotUnitsOf1000());
		}
	}

}
