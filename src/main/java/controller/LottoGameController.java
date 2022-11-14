package controller;

import model.Lotto;
import model.LottoRandomNumberGenerator;
import model.LottoTotalCountCalculator;
import view.LottoOutput;
import view.LottoPurchaseAmountInput;
import view.LottoTotalCountOutput;

public class LottoGameController {

	private LottoPurchaseAmountInput lottoPurchaseAmountInput = new LottoPurchaseAmountInput();
	private LottoTotalCountCalculator lottoTotalCountCalculator = new LottoTotalCountCalculator();
	private LottoOutput lottoOutput = new LottoOutput();
	private LottoTotalCountOutput lottoTotalCountOutput = new LottoTotalCountOutput();
	private LottoRandomNumberGenerator randomGenerator = new LottoRandomNumberGenerator();

	public void gameProgress() {
		long lottoPurchaseAmount = lottoPurchaseAmountInput();
		long lottoTotalCount = lottoTotalCount(lottoPurchaseAmount);
		lottoTotalCountPrint(lottoTotalCount);

		for (int lottoCount = 0; lottoCount < lottoTotalCount; lottoCount++) {
			Lotto lotto = lottoCreate();
			lottoPrint(lotto);
		}
	}

	private long lottoPurchaseAmountInput() {
		long purchaseAmount = lottoPurchaseAmountInput.readLottoPurchaseAmount();
		return purchaseAmount;
	}

	private long lottoTotalCount(long purchaseAmount) {
		return lottoTotalCountCalculator.calculateLottoTotalCount(purchaseAmount);
	}

	private void lottoTotalCountPrint(long totalCount) {
		lottoTotalCountOutput.showLottoCount(totalCount);
	}

	private Lotto lottoCreate() {
		Lotto lotto = new Lotto(randomGenerator.randomUniqueNumbersGenerate());
		return lotto;
	}

	private void lottoPrint(Lotto lotto) {
		lottoOutput.showLotto(lotto);
	}
}