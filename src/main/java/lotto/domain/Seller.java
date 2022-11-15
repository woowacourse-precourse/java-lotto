package lotto.domain;

import java.util.List;

import lotto.util.ErrorMessage;

public class Seller {

	public static final int LOTTO_PRICE = 1_000;

	public static List<Lotto> sellLottoTickets(int money) {
		validate(money);
		return Lotto.newInstances(money / LOTTO_PRICE);
	}

	private static void validate(Integer money) {
		if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorMessage.isNotUnitsOf1000());
		}
	}

}
