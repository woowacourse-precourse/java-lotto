package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

	public static void run() {
		createPurchaseAmount();
	}

	private static void createPurchaseAmount() {
		LottoView.displayInputPurchaseAmount();
		String userInput = LottoView.getUserInput();
		LottoService.setMoney(userInput);
	}
}
