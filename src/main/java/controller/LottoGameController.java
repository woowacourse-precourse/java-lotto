package controller;

import model.LottoTotalCountCalculator;
import view.InputLottoPurchaseAmount;

public class LottoGameController {
	
	private InputLottoPurchaseAmount inputLotto = new InputLottoPurchaseAmount();
	private LottoTotalCountCalculator lottoTotalCountCalculator = new LottoTotalCountCalculator();

	private long lottoPurchaseAmountInput() {
		long purchaseAmount = inputLotto.readLottoPurchaseAmount();
		return purchaseAmount;
	}
	
	private long lottoTotalCount(long purchaseAmount) {
		return lottoTotalCountCalculator.calculateLottoTotalCount(purchaseAmount);
	}
}