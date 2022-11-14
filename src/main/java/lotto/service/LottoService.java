package lotto.service;

import lotto.domain.Money;

public class LottoService {

	public static void setMoney(String userInput) {
		Money.from(userInput);
	}
}
