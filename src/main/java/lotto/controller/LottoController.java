package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

	public static void run() {
		createPurchaseAmount();
		displayPurchasedLottoAmount();

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
}
