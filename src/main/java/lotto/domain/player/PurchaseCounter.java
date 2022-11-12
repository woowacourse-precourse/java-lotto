package lotto.domain.player;

import lotto.domain.util.Rule;

import static lotto.ui.ConsoleOutput.*;

public class PurchaseCounter {
	public int countLotto(PurchaseAmount purchaseAmount) {
		int purchasedLotto = (int) (purchaseAmount.valueOf() / Rule.LOTTO_PRICE.getMoney());
		PrintNotificationMessage(purchasedLotto);
		return purchasedLotto;
	}
}
