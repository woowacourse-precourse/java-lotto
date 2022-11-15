package controller;

import java.util.List;
import java.util.Map;

import model.Lotto;
import model.LottoMachine;
import model.LottoProfitCalculator;
import model.LottoRandomNumberGenerator;
import model.LottoTotalCountCalculator;

import view.LottoBonusNumberInput;
import view.LottoOutputView;
import view.LottoPurchaseAmountInput;
import view.LottoWinningNumberInput;

public class LottoGameController {

	private LottoPurchaseAmountInput lottoPurchaseAmountInput = new LottoPurchaseAmountInput();
	private LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
	private LottoBonusNumberInput lottoBonusNumberInput = new LottoBonusNumberInput();

	private LottoOutputView lottoOutputView = new LottoOutputView();

	private LottoRandomNumberGenerator randomGenerator = new LottoRandomNumberGenerator();
	private LottoMachine lottoMachine = new LottoMachine();
	private LottoTotalCountCalculator lottoTotalCountCalculator = new LottoTotalCountCalculator();
	private LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator();

	public void gameProgress() {
		long lottoPurchaseAmount = lottoPurchaseAmountInput();
		long lottoTotalCount = lottoTotalCount(lottoPurchaseAmount);
		lottoTotalCountPrint(lottoTotalCount);

		for (int lottoCount = 0; lottoCount < lottoTotalCount; lottoCount++) {
			Lotto lotto = lottoCreate();
			lottoMachine.addLotto(lotto);
			lottoPrint(lotto);
		}
		System.out.println();

		List<Integer> winningNumbers = lottoWinningNumberInput.readLottoWinningNumber();
		int bonusNumber = lottoBonusNumberInput.readLottoBonusNumber();

		Map<Integer, Integer> winningDetails = lottoMachine.calculateLottoResult(winningNumbers, bonusNumber);
		lottoOutputView.showWinningResult(winningDetails);

		double lottoProfit = lottoProfitCalculator.calculateLottoProfit(winningDetails, lottoPurchaseAmount);

		lottoOutputView.showLottoProfit(lottoProfit);
	}

	private long lottoPurchaseAmountInput() {
		long purchaseAmount = lottoPurchaseAmountInput.readLottoPurchaseAmount();
		return purchaseAmount;
	}

	private long lottoTotalCount(long purchaseAmount) {
		return lottoTotalCountCalculator.calculateLottoTotalCount(purchaseAmount);
	}

	private void lottoTotalCountPrint(long totalCount) {
		lottoOutputView.showLottoCount(totalCount);
	}

	private Lotto lottoCreate() {
		Lotto lotto = new Lotto(randomGenerator.randomUniqueNumbersGenerate());
		return lotto;
	}

	private void lottoPrint(Lotto lotto) {
		lottoOutputView.showLotto(lotto);
	}
}