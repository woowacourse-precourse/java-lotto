package lotto.domain.player;

import lotto.domain.util.Rule;

import static lotto.ui.ConsoleOutput.*;

public class PurchaseCounter {

	private final long purchasedLotto;

	private PurchaseCounter(PurchaseAmount purchaseAmount){
		this.purchasedLotto = countLotto(purchaseAmount);
		PrintNotificationMessage(this.valueOf());
	}

	public long countLotto(PurchaseAmount purchaseAmount) {
		return purchaseAmount.valueOf() / Rule.LOTTO_PRICE.getMoney();

	}

	public static PurchaseCounter from(PurchaseAmount purchaseAmount){
		return new PurchaseCounter(purchaseAmount);
	}

	public int valueOf(){
		return (int) purchasedLotto;
	}
}
