package lotto;

import lotto.controller.LottoController;

public class Application {

	private static final LottoController lottoController = new LottoController();

	public static void main(String[] args) {
		lottoController.run();
	}
}
