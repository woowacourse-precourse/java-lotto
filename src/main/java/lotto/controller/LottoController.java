package lotto.controller;

import lotto.view.InputView;

public class LottoController {

	public void run() {
		chargeLottoPurchaseAmount();
	}

	public void chargeLottoPurchaseAmount() {
		InputView inputView = new InputView();
		String userNumber = inputView.inputUserMoney();
		inputView.validCheck(userNumber);

	}
}
