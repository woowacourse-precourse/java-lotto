package lotto.controller;

import lotto.domain.PurchasingAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	public void excute() {
		PurchasingAmount purchasingAmount = new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
		int numberOfTickets = purchasingAmount.getNumberOfTickets();
		outputView.printNumberOfTickets(numberOfTickets);
	}
}
