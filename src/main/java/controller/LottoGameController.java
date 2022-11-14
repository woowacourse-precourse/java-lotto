package controller;

import view.InputLottoPurchaseAmount;

public class LottoGameController {
	
	InputLottoPurchaseAmount inputLotto = new InputLottoPurchaseAmount();

	public long lottoPurchaseAmountInput() {
		long purchaseAmount = inputLotto.readLottoPurchaseAmount();
		return purchaseAmount;
	}
}