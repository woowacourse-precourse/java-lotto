package controller;

import model.LottoTotalCountCalculator;
import view.InputLottoPurchaseAmount;
import view.OutputLotto;

public class LottoGameController {
	
	private InputLottoPurchaseAmount inputLotto = new InputLottoPurchaseAmount();
	private LottoTotalCountCalculator lottoTotalCountCalculator = new LottoTotalCountCalculator();
	private OutputLotto outputLotto = new OutputLotto();

	private long lottoPurchaseAmountInput() {
		long purchaseAmount = inputLotto.readLottoPurchaseAmount();
		return purchaseAmount;
	}
	
	private long lottoTotalCount(long purchaseAmount) {
		return lottoTotalCountCalculator.calculateLottoTotalCount(purchaseAmount);
	}
	
	private void lottoTotalCountPrint(long totalCount) {
		outputLotto.showLottoCount(totalCount);
	}
}