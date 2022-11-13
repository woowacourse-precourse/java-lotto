package lotto.controller;

import lotto.domain.PurchasingAmount;
import lotto.view.InputView;

public class LottoController {
	InputView inputView = new InputView();
	PurchasingAmount purchasingAmount = new PurchasingAmount(Integer.parseInt(inputView.getPurchasingAmount()));
	int numberOfTickets = purchasingAmount.getNumberOfTickets();

}
