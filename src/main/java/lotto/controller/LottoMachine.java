package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

	private Buyer buyer;

	public void run() {
		setting();
	}

	private void setting() {
		buyer = new Buyer(InputView.inputAmount());
		OutputView.printAllLottoNumber(buyer.getLotto());
	}
}
