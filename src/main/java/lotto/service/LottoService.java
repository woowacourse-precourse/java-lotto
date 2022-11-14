package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Money;

public class LottoService {

	public static void setMoney(String userInput) {
		Money.from(userInput);
	}

	public static int purchasedLottoAmount() {
		return Money.getPurchaseAmount() / 1000;
	}

	public static void createUserLottos(int purchasedLottoCount) {
		Lottos.createUserLottos(purchasedLottoCount);
	}
}
