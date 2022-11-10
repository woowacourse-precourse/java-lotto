package lotto.controller;

import lotto.view.InputView;

public class LottoController {
	private final InputView inputView;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void runLotto() {
		String money = inputView.getMoney();
	}
}
