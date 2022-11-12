package lotto.domain.player;

import lotto.domain.util.Rule;

import static lotto.ui.ConsoleOutput.*;

public class PurchaseCount {
	private final long purchasedLotto;

	private PurchaseCount(PurchaseAmount purchaseAmount){
		this.purchasedLotto = countLotto(purchaseAmount);
		PrintNotificationMessage(this.toLotto());
	}

	public long countLotto(PurchaseAmount purchaseAmount) {
		return purchaseAmount.toMoney() / Rule.LOTTO_PRICE.getMoney();
	}

	public static PurchaseCount from(PurchaseAmount purchaseAmount){
		return new PurchaseCount(purchaseAmount);
	}

	public int toLotto(){
		return (int) purchasedLotto;
	}
}
