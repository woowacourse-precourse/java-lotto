package lotto.domain;

import java.util.List;

import lotto.ErrorMessage;

public class Seller {

	private static final int LOTTO_PRICE = 1_000;
	private static final String PURCHASE_ANNOUNCEMENT = "%s개를 구매했습니다.";

	private static boolean isNotUnitsOf1000(Integer money) {
		return money < LOTTO_PRICE || money % LOTTO_PRICE != 0;
	}

	public List<Lotto> sellLottoTickets(int money) {
		if (isNotUnitsOf1000(money)) {
			throw new IllegalArgumentException(ErrorMessage.isNotUnitsOf1000());
		}
		System.out.println(String.format(PURCHASE_ANNOUNCEMENT, money / LOTTO_PRICE));
		return Lotto.newInstances(money / LOTTO_PRICE);
	}

}
