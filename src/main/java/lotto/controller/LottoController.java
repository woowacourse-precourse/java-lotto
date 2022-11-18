package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

	public static void run() {
		createPurchaseAmount();
		displayPurchasedLottoAmount();
		displayPurchasedLottos();
		createWinningLottoAndBonusNumber();
		displayWinningStatistics();
		displayProfitRate();
	}

	private static void createPurchaseAmount() {
		LottoView.displayInputPurchaseAmount();
		String userInput = LottoView.getUserInput();
		LottoService.setMoney(userInput);
	}

	private static void displayPurchasedLottoAmount() {
		int purchasedLottoCount = LottoService.purchasedLottoAmount();
		LottoView.displayPurchasedLottoAmount(purchasedLottoCount);
	}

	private static void displayPurchasedLottos() {
		int purchasedLottoCount = LottoService.purchasedLottoAmount();
		LottoService.createUserLottos(purchasedLottoCount);
		LottoView.displayPurchasedLottos(Lottos.getLottos());
	}

	private static void createWinningLottoAndBonusNumber() {
		createWinningLotto();
		createBonusNumber();
	}

	private static void createWinningLotto() {
		LottoView.displayInputWinningLotto();
		LottoService.createWinningLotto(LottoView.getUserInput());
	}

	private static void createBonusNumber() {
		LottoView.displayInputBonusNumber();
		LottoService.createBonusNumber(LottoView.getUserInput());
	}

	private static void displayWinningStatistics() {
		LottoService.calculateStatistics();
		LottoView.displayWinningStatistics();
	}

	private static void displayProfitRate() {
		LottoService.calculateProfitRate(Money.getPurchaseAmount());
		LottoView.displayProfitRate();
	}
}
