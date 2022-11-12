package lotto.domain;

import lotto.Setup;

import static lotto.ui.ConsoleOutput.*;

public class PurchaseCounter {
	public int countLotto(long purchaseAmount) {
		int purchasedLotto = (int) (purchaseAmount / Setup.LOTTO_PRICE.getMoney());
		PrintNotificationMessage(purchasedLotto);
		return purchasedLotto;
	}
}
