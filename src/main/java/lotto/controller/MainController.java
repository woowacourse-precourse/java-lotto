package lotto.controller;

import lotto.model.LottoCompany;
import lotto.model.LottoMachine;
import lotto.model.PrizeChecker;
import lotto.model.Wallet;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
	private final InputView inputView = InputView.getInstance();
	private final OutputView outputView = OutputView.getInstance();

	public void run() {
		int purchaseAmount = inputView.createPurchaseAmount();
		LottoCompany lottoCompany = inputView.createWinningLotto();
		Wallet wallet = new LottoMachine(purchaseAmount).buyLotto();
		PrizeChecker prizeChecker;

		outputView.LottoInformation(wallet.getMyLotto().size(), wallet.getMyLotto());
		prizeChecker = new PrizeChecker(lottoCompany, wallet.getMyLotto());

		outputView.lottoResult(prizeChecker.getPrizeResult());
		outputView.yield(prizeChecker.calculationYield(wallet.getReceiptLotto()));
	}
}
